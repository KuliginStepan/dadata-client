package com.kuliginstepan.dadata.client;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.netty.handler.timeout.ReadTimeoutHandler;
import org.springframework.http.HttpHeaders;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.http.codec.json.Jackson2JsonDecoder;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;
import reactor.netty.tcp.TcpClient;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static java.util.Optional.ofNullable;

public class DadataClientBuilder {

    private WebClient webClient;
    private Duration timeout;
    private String token;
    private String baseUrl;
    private Integer maxInMemorySize;


    public DadataClientBuilder webClient(WebClient webClient) {
        this.webClient = webClient;
        return this;
    }

    public DadataClientBuilder timeout(Duration timeout) {
        this.timeout = timeout;
        return this;
    }

    public DadataClientBuilder token(String token) {
        this.token = token;
        return this;
    }

    public DadataClientBuilder baseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
        return this;
    }

    public DadataClientBuilder maxInMemorySize(int maxInMemorySize) {
        this.maxInMemorySize = maxInMemorySize;
        return this;
    }

    public DadataClient build() {
        if (webClient != null) {
            return new DadataClient(webClient);
        }
        if (token == null) {
            throw new IllegalArgumentException("Token or WebClient is needed to construct DadataClient");
        }
        DadataClientProperties defaultProps = new DadataClientProperties();
        TcpClient timeoutClient = TcpClient.create()
            .doOnConnected(con -> con.addHandlerLast(
                new ReadTimeoutHandler(ofNullable(timeout).orElse(defaultProps.getTimeout()).toMillis(),
                    TimeUnit.MILLISECONDS)));
        ObjectMapper mapper = Jackson2ObjectMapperBuilder.json()
            .visibility(PropertyAccessor.CREATOR, Visibility.NON_PRIVATE)
            .build();
        WebClient client = WebClient.builder()
            .clientConnector(new ReactorClientHttpConnector(HttpClient.from(timeoutClient)))
            .baseUrl(ofNullable(baseUrl).orElse(defaultProps.getBaseUrl()))
            .defaultHeader(HttpHeaders.AUTHORIZATION, "Token " + token)
            .codecs(codecs -> {
                codecs.defaultCodecs().jackson2JsonDecoder(new Jackson2JsonDecoder(mapper));
                codecs.defaultCodecs().maxInMemorySize(defaultProps.getMaxInMemorySize());
            })
            .build();
        return new DadataClient(client);
    }

}
