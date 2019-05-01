package com.kuliginstepan.dadata;

import com.kuliginstepan.dadata.domain.DadataRequest;
import com.kuliginstepan.dadata.domain.DadataResponse;
import com.kuliginstepan.dadata.domain.SimpleDadataRequest;
import com.kuliginstepan.dadata.domain.Suggestion;
import com.kuliginstepan.dadata.domain.SuggestionType;
import com.kuliginstepan.dadata.domain.address.Address;
import com.kuliginstepan.dadata.domain.address.AddressDadataRequest;
import com.kuliginstepan.dadata.domain.address.AddressSuggestion;
import com.kuliginstepan.dadata.domain.address.GeolocateDadataRequest;
import com.kuliginstepan.dadata.domain.bank.Bank;
import com.kuliginstepan.dadata.domain.bank.BankDadataRequest;
import com.kuliginstepan.dadata.domain.bank.BankSuggestion;
import com.kuliginstepan.dadata.domain.email.Email;
import com.kuliginstepan.dadata.domain.email.EmailSuggestion;
import com.kuliginstepan.dadata.domain.fio.Fio;
import com.kuliginstepan.dadata.domain.fio.FioDadataRequest;
import com.kuliginstepan.dadata.domain.fio.FioSuggestion;
import com.kuliginstepan.dadata.domain.organization.Organization;
import com.kuliginstepan.dadata.domain.organization.OrganizationDadataRequest;
import com.kuliginstepan.dadata.domain.organization.OrganizationSuggestion;
import com.kuliginstepan.dadata.exception.DadataException;
import com.kuliginstepan.dadata.exception.ErrorDetails;
import io.netty.handler.timeout.ReadTimeoutHandler;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;
import reactor.netty.tcp.TcpClient;

@RequiredArgsConstructor
@Slf4j
public class DadataClient {

    private static final String BASE_API_URL = "https://suggestions.dadata.ru/suggestions/api/4_1/rs";
    private static final String SUGGESTION_PREFIX = "/suggest";
    private static final String GEOLOCATE_PREFIX = "/geolocate";
    private static final String FIND_BY_ID_PREFIX = "/findById";
    private static final Duration DEFAULT_TIMEOUT = Duration.of(5, ChronoUnit.SECONDS);
    private static final SuggestionType<Organization> ORGANIZATION_SUGGESTION = new OrganizationSuggestion();
    private static final SuggestionType<Address> ADDRESS_SUGGESTION = new AddressSuggestion();
    private static final SuggestionType<Bank> BANK_SUGGESTION = new BankSuggestion();
    private static final SuggestionType<Fio> FIO_SUGGESTION = new FioSuggestion();
    private static final SuggestionType<Email> EMAIL_SUGGESTION = new EmailSuggestion();

    private final String token;
    private final Duration timeout;

    public DadataClient(String token) {
        this.token = token;
        timeout = DEFAULT_TIMEOUT;
    }

    public Flux<Suggestion<Organization>> suggestOrganization(OrganizationDadataRequest request) {
        return suggest(ORGANIZATION_SUGGESTION, request);
    }

    public Flux<Suggestion<Address>> suggestAddress(AddressDadataRequest request) {
        return suggest(ADDRESS_SUGGESTION, request);
    }

    public Flux<Suggestion<Bank>> suggestBank(BankDadataRequest request) {
        return suggest(BANK_SUGGESTION, request);
    }

    public Flux<Suggestion<Fio>> suggestFio(FioDadataRequest request) {
        return suggest(FIO_SUGGESTION, request);
    }

    public Flux<Suggestion<Email>> suggestEmail(String query) {
        return suggest(EMAIL_SUGGESTION, new SimpleDadataRequest(query));
    }

    public Mono<Suggestion<Address>> findAddressById(String id) {
        return findById(ADDRESS_SUGGESTION, new SimpleDadataRequest(id));
    }

    public Mono<Suggestion<Organization>> findOrganizationById(String id) {
        return findById(ORGANIZATION_SUGGESTION, new SimpleDadataRequest(id));
    }

    public Flux<Suggestion<Address>> geolocate(GeolocateDadataRequest request) {
        return executeOperation(ADDRESS_SUGGESTION.getResponseClass(), request, GEOLOCATE_PREFIX,
            ADDRESS_SUGGESTION.getSuggestOperationPrefix());
    }

    protected <T> Flux<Suggestion<T>> suggest(SuggestionType<T> suggestionType, DadataRequest request) {
        return executeOperation(suggestionType.getResponseClass(), request, SUGGESTION_PREFIX,
            suggestionType.getSuggestOperationPrefix());
    }

    protected <T> Mono<Suggestion<T>> findById(SuggestionType<T> suggestionType, DadataRequest request) {
        return suggestionType.getFindByIdOperationPrefix()
            .map(prefix -> executeOperation(suggestionType.getResponseClass(), request, FIND_BY_ID_PREFIX, prefix))
            .map(Flux::next)
            .orElseThrow(() -> new UnsupportedOperationException(
                "Operation 'findById' not supported for operation type " + suggestionType.getClass()));
    }

    private static <T> Mono<T> responseToBody(ClientResponse response, ParameterizedTypeReference<T> type) {
        if (response.statusCode().is2xxSuccessful()) {
            return response.bodyToMono(type);
        } else {
            return response.bodyToMono(ErrorDetails.class)
                .flatMap(error -> Mono.error(new DadataException(response.statusCode(), error)));
        }
    }

    protected <T> Flux<Suggestion<T>> executeOperation(ParameterizedTypeReference<DadataResponse<T>> responseClass,
        DadataRequest request, String operationPrefix, String suggestionTypePrefix) {
        return webClientBuilder().build()
            .post().uri(operationPrefix + suggestionTypePrefix)
            .body(BodyInserters.fromObject(request))
            .exchange()
            .flatMap(clientResponse -> responseToBody(clientResponse, responseClass))
            .map(DadataResponse::getSuggestions)
            .flatMapMany(Flux::fromIterable);
    }

    private WebClient.Builder webClientBuilder() {
        TcpClient timeoutClient = TcpClient.create()
            .doOnConnected(
                con -> con.addHandlerLast(new ReadTimeoutHandler(timeout.toMillis(), TimeUnit.MILLISECONDS)));
        return WebClient.builder()
            .clientConnector(new ReactorClientHttpConnector(HttpClient.from(timeoutClient)))
            .baseUrl(BASE_API_URL)
            .defaultHeader(HttpHeaders.AUTHORIZATION, "Token " + token);
    }
}
