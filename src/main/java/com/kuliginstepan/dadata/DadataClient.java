package com.kuliginstepan.dadata;

import com.kuliginstepan.dadata.domain.Address;
import com.kuliginstepan.dadata.exception.DadataException;
import com.kuliginstepan.dadata.domain.DadataRequest;
import com.kuliginstepan.dadata.domain.DadataResponse;
import com.kuliginstepan.dadata.domain.DadataResponse.Suggestion;
import com.kuliginstepan.dadata.exception.ErrorDetails;
import io.netty.handler.timeout.ReadTimeoutHandler;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;
import reactor.netty.tcp.TcpClient;

@RequiredArgsConstructor
@Slf4j
public class DadataClient {

    private final String token;
    private final Duration timeout;

    public DadataClient(String token) {
        this.token = token;
        timeout = Duration.of(5, ChronoUnit.SECONDS);
    }

    public Mono<Suggestion<Address>> findAddress(String query) {
        return webClientBuilder().build()
            .post().uri("/suggest/address")
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON)
            .body(BodyInserters.fromObject(new DadataRequest(query)))
            .exchange()
            .flatMap(clientResponse -> responseToBody(clientResponse,
                new ParameterizedTypeReference<DadataResponse<Address>>() {}))
            .map(DadataResponse::getSuggestions)
            .filter(suggestions -> !suggestions.isEmpty())
            .map(suggestions -> suggestions.get(0));
    }

    public Mono<Suggestion<Address>> findAddressById(String id) {
        return webClientBuilder().build()
            .post().uri("/findById/address")
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON)
            .body(BodyInserters.fromObject(new DadataRequest(id)))
            .retrieve()
            .bodyToMono(new ParameterizedTypeReference<DadataResponse<Address>>() {})
            .map(DadataResponse::getSuggestions)
            .filter(suggestions -> !suggestions.isEmpty())
            .map(suggestions -> suggestions.get(0));
    }

    private static <T> Mono<T> responseToBody(ClientResponse response, ParameterizedTypeReference<T> type) {
        if (response.statusCode().is2xxSuccessful()) {
            return response.bodyToMono(type);
        } else {
            return response.bodyToMono(ErrorDetails.class)
                .flatMap(error -> Mono.error(new DadataException(response.statusCode(), error)));
        }
    }

    private WebClient.Builder webClientBuilder() {
        TcpClient timeoutClient = TcpClient.create()
            .doOnConnected(con -> con.addHandlerLast(new ReadTimeoutHandler(timeout.toMillis(), TimeUnit.MILLISECONDS)));
        return WebClient.builder()
            .clientConnector(new ReactorClientHttpConnector(HttpClient.from(timeoutClient)))
            .baseUrl("https://suggestions.dadata.ru/suggestions/api/4_1/rs")
            .defaultHeader(HttpHeaders.AUTHORIZATION, "Token " + token);
    }
}
