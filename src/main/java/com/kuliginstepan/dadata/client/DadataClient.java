package com.kuliginstepan.dadata.client;

import com.kuliginstepan.dadata.client.domain.BasicRequest;
import com.kuliginstepan.dadata.client.domain.DadataResponse;
import com.kuliginstepan.dadata.client.domain.Suggestion;
import com.kuliginstepan.dadata.client.domain.SuggestionType;
import com.kuliginstepan.dadata.client.domain.address.Address;
import com.kuliginstepan.dadata.client.domain.address.AddressRequest;
import com.kuliginstepan.dadata.client.domain.address.GeolocateRequest;
import com.kuliginstepan.dadata.client.domain.bank.Bank;
import com.kuliginstepan.dadata.client.domain.bank.BankRequest;
import com.kuliginstepan.dadata.client.domain.court.Court;
import com.kuliginstepan.dadata.client.domain.court.CourtRequest;
import com.kuliginstepan.dadata.client.domain.delivery.Delivery;
import com.kuliginstepan.dadata.client.domain.email.Email;
import com.kuliginstepan.dadata.client.domain.fio.Fio;
import com.kuliginstepan.dadata.client.domain.fio.FioRequest;
import com.kuliginstepan.dadata.client.domain.fms.FmsUnit;
import com.kuliginstepan.dadata.client.domain.fms.FmsUnitRequest;
import com.kuliginstepan.dadata.client.domain.fns.FnsUnit;
import com.kuliginstepan.dadata.client.domain.fns.FnsUnitRequest;
import com.kuliginstepan.dadata.client.domain.organization.FindOrganizationByIdRequest;
import com.kuliginstepan.dadata.client.domain.organization.Organization;
import com.kuliginstepan.dadata.client.domain.organization.OrganizationRequest;
import com.kuliginstepan.dadata.client.domain.postal.PostalOffice;
import com.kuliginstepan.dadata.client.domain.postal.PostalOfficeRequest;
import com.kuliginstepan.dadata.client.exception.DadataException;
import com.kuliginstepan.dadata.client.exception.ErrorDetails;
import com.kuliginstepan.dadata.client.util.DadataWebClientBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

import static com.kuliginstepan.dadata.client.util.DadataWebClientBuilder.buildDadataWebClient;

@Slf4j
public class DadataClient {

    private static final String SUGGESTION_PREFIX = "/suggest";
    private static final String GEOLOCATE_PREFIX = "/geolocate";
    private static final String FIND_BY_ID_PREFIX = "/findById";

    private final WebClient webClient;

    /**
     * Builds dadata client with supplied web client (just in case you'd like to control webclient manually)
     * @param webClient preferably, but not necessary, should be built with {@link DadataWebClientBuilder#buildDadataWebClient(String, String, Duration)}
     */
    public DadataClient(WebClient webClient) {
        this.webClient = webClient;
    }

    /**
     * Builds default dadata client with default url and timeout
     * @param token dadata auth token
     */
    public DadataClient(String token) {
        DadataClientProperties defaultProps = new DadataClientProperties();
        this.webClient = buildDadataWebClient(defaultProps.getBaseUrl(), token, defaultProps.getTimeout());
    }

    public Flux<Suggestion<Organization>> suggestOrganization(OrganizationRequest request) {
        return suggest(SuggestionTypes.ORGANIZATION, request);
    }

    public Flux<Suggestion<Address>> suggestAddress(AddressRequest request) {
        return suggest(SuggestionTypes.ADDRESS, request);
    }

    public Flux<Suggestion<Bank>> suggestBank(BankRequest request) {
        return suggest(SuggestionTypes.BANK, request);
    }

    public Flux<Suggestion<Fio>> suggestFio(FioRequest request) {
        return suggest(SuggestionTypes.FIO, request);
    }

    public Flux<Suggestion<Email>> suggestEmail(BasicRequest request) {
        return suggest(SuggestionTypes.EMAIL, request);
    }

    public Flux<Suggestion<FmsUnit>> suggestFmsUnit(FmsUnitRequest request) {
        return suggest(SuggestionTypes.FMS, request);
    }

    public Flux<Suggestion<FnsUnit>> suggestFnsUnit(FnsUnitRequest request) {
        return suggest(SuggestionTypes.FNS, request);
    }

    public Flux<Suggestion<PostalOffice>> suggestPostalOffice(PostalOfficeRequest request) {
        return suggest(SuggestionTypes.POSTAL_OFFICE, request);
    }

    public Flux<Suggestion<Court>> suggestCourt(CourtRequest request) {
        return suggest(SuggestionTypes.COURT, request);
    }

    public Mono<Suggestion<Address>> findAddressById(String id) {
        return findById(SuggestionTypes.ADDRESS, new BasicRequest(id));
    }

    public Mono<Suggestion<Organization>> findOrganizationById(String id) {
        return findById(SuggestionTypes.ORGANIZATION, new BasicRequest(id));
    }

    public Mono<Suggestion<Organization>> findOrganizationById(FindOrganizationByIdRequest request) {
        return findById(SuggestionTypes.ORGANIZATION, request);
    }

    /**
     * @param id Fms unit code. Format: 'XXX-XXX'
     */
    public Mono<Suggestion<FmsUnit>> findFmsUnitById(String id) {
        return findById(SuggestionTypes.FMS, new BasicRequest(id));
    }

    /**
     * @param id Fns unit code or inn
     */
    public Mono<Suggestion<FnsUnit>> findFnsUnitById(String id) {
        return findById(SuggestionTypes.FNS, new BasicRequest(id));
    }

    /**
     * @param index Postal office index
     */
    public Mono<Suggestion<PostalOffice>> findPostalOfficeById(String index) {
        return findById(SuggestionTypes.POSTAL_OFFICE, new BasicRequest(index));
    }

    /**
     * @param id Court code
     */
    public Mono<Suggestion<Court>> findCourtById(String id) {
        return findById(SuggestionTypes.COURT, new BasicRequest(id));
    }

    /**
     * @param id City kladr id
     */
    public Mono<Suggestion<Delivery>> findDeliveryById(String id) {
        return findById(SuggestionTypes.DELIVERY, new BasicRequest(id));
    }

    public Flux<Suggestion<Address>> geolocate(GeolocateRequest request) {
        return executeOperation(SuggestionTypes.ADDRESS.getResponseClass(), request, GEOLOCATE_PREFIX,
            SuggestionTypes.ADDRESS.getSuggestOperationPrefix());
    }

    protected <T> Flux<Suggestion<T>> suggest(SuggestionType<T> suggestionType, BasicRequest request) {
        return executeOperation(suggestionType.getResponseClass(), request, SUGGESTION_PREFIX,
            suggestionType.getSuggestOperationPrefix());
    }

    protected <T> Mono<Suggestion<T>> findById(SuggestionType<T> suggestionType, BasicRequest request) {
        return executeOperation(suggestionType.getResponseClass(), request, FIND_BY_ID_PREFIX,
            suggestionType.getFindByIdOperationPrefix()).next();
    }

    protected <T> Flux<Suggestion<T>> executeOperation(ParameterizedTypeReference<DadataResponse<T>> responseClass,
        BasicRequest request, String operationPrefix, String suggestionTypePrefix) {
        return webClient
            .post().uri(operationPrefix + suggestionTypePrefix)
            .body(BodyInserters.fromObject(request))
            .exchange()
            .flatMap(clientResponse -> responseToBody(clientResponse, responseClass))
            .map(DadataResponse::getSuggestions)
            .flatMapMany(Flux::fromIterable);
    }

    private static <T> Mono<T> responseToBody(ClientResponse response, ParameterizedTypeReference<T> type) {
        if (response.statusCode().is2xxSuccessful()) {
            return response.bodyToMono(type);
        } else {
            return response.bodyToMono(ErrorDetails.class)
                .flatMap(error -> Mono.error(new DadataException(response.statusCode(), error)));
        }
    }
}
