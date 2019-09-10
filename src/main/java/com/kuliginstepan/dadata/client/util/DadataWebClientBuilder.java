package com.kuliginstepan.dadata.client.util;

import io.netty.handler.timeout.ReadTimeoutHandler;
import org.springframework.http.HttpHeaders;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;
import reactor.netty.tcp.TcpClient;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class DadataWebClientBuilder {

    public static WebClient buildDadataWebClient(String url, String token, Duration timeout) {
        TcpClient timeoutClient = TcpClient.create()
                .doOnConnected(
                        con -> con.addHandlerLast(new ReadTimeoutHandler(timeout.toMillis(), TimeUnit.MILLISECONDS)));
        return WebClient.builder()
                .clientConnector(new ReactorClientHttpConnector(HttpClient.from(timeoutClient)))
                .baseUrl(url)
                .defaultHeader(HttpHeaders.AUTHORIZATION, "Token " + token)
                .build();
    }

}
