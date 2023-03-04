package com.kuliginstepan.dadata.client;

import static java.lang.Math.toIntExact;
import static java.util.Optional.ofNullable;

import io.netty.handler.ssl.util.InsecureTrustManagerFactory;
import io.netty.handler.timeout.ReadTimeoutHandler;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.springframework.http.HttpHeaders;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;
import reactor.netty.tcp.DefaultSslContextSpec;
import reactor.netty.transport.ProxyProvider;

public class DadataClientBuilder {

    private static final Map<ProxyProvider.Proxy, PasswordAuthentication> proxyAuthProps = new HashMap<>() {{
        put(ProxyProvider.Proxy.HTTP, new PasswordAuthentication("http.proxyUser", "http.proxyPassword".toCharArray()));
        put(ProxyProvider.Proxy.SOCKS4,
            new PasswordAuthentication("java.net.socks.username", "java.net.socks.password".toCharArray()));
        put(ProxyProvider.Proxy.SOCKS5,
            new PasswordAuthentication("java.net.socks.username", "java.net.socks.password".toCharArray()));
    }};

    private WebClient webClient;

    private DadataClientProperties clientProperties = new DadataClientProperties();

    public DadataClientBuilder webClient(WebClient webClient) {
        this.webClient = webClient;
        return this;
    }

    public DadataClientBuilder clientProperties(DadataClientProperties clientProperties) {
        this.clientProperties = clientProperties;
        return this;
    }

    public DadataClient build() throws IllegalArgumentException {
        if (webClient != null) {
            return new DadataClient(webClient);
        }
        if (clientProperties.getToken() == null) {
            throw new IllegalArgumentException("Token or WebClient is needed to construct DadataClient");
        }

        WebClient client = WebClient.builder()
            .clientConnector(new ReactorClientHttpConnector(buildHttpClient()))
            .baseUrl(clientProperties.getBaseUrl())
            .defaultHeader(HttpHeaders.AUTHORIZATION, "Token " + clientProperties.getToken())
            .codecs(codecs -> codecs.defaultCodecs()
                .maxInMemorySize(toIntExact(clientProperties.getMaxInMemorySize().toBytes())))
            .build();
        return new DadataClient(client);
    }

    private HttpClient buildHttpClient() {
        HttpClient httpClient = HttpClient.create()
            .doOnConnected(con -> con.addHandlerLast(
                new ReadTimeoutHandler(clientProperties.getTimeout().toMillis(),
                    TimeUnit.MILLISECONDS)));

        DadataClientProperties.ProxyProperties proxyProperties = clientProperties.getProxy();
        if (proxyProperties != null) {
            httpClient = httpClient.proxy(typeSpec -> {
                ProxyProvider.Builder builder = typeSpec.type(proxyProperties.getType())
                    .address(new InetSocketAddress(proxyProperties.getServer(), proxyProperties.getPort()));

                PasswordAuthentication authProps = proxyAuthProps.get(proxyProperties.getType());

                ofNullable(System.getProperty(authProps.getUserName())).ifPresent(username ->
                    builder.username(username)
                        .password((auth) -> System.getProperty(String.valueOf(authProps.getPassword()))));
            });
        }

        if (!clientProperties.isVerifySsl()) {
            httpClient = httpClient.secure(sslContextSpec ->
                sslContextSpec.sslContext(
                    DefaultSslContextSpec.forClient()
                        .configure(sslContextBuilder ->
                            sslContextBuilder.trustManager(InsecureTrustManagerFactory.INSTANCE)
                        )
                )
            );
        }

        return httpClient;
    }
}
