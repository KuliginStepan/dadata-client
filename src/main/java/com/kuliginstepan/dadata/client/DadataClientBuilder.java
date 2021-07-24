package com.kuliginstepan.dadata.client;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;
import io.netty.handler.timeout.ReadTimeoutHandler;
import org.springframework.http.HttpHeaders;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.http.codec.json.Jackson2JsonDecoder;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.util.unit.DataSize;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;
import reactor.netty.tcp.ProxyProvider;
import reactor.netty.tcp.TcpClient;

import java.net.InetSocketAddress;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static java.lang.Math.toIntExact;
import static java.util.Optional.ofNullable;

public class DadataClientBuilder {

    private static final String PROP_SOCKS_USERNAME = "java.net.socks.username";
    private static final String PROP_SOCKS_PASSWORD = "java.net.socks.password";

    private static final String PROP_HTTP_USERNAME = "http.proxyUser";
    private static final String PROP_HTTP_PASSWORD = "http.proxyPassword";

    private WebClient webClient;

    private DadataClientProperties clientProperties = new DadataClientProperties();

    public DadataClientBuilder webClient(WebClient webClient) {
        this.webClient = webClient;
        return this;
    }

    /**
     * @see DadataClientBuilder#clientProperties(DadataClientProperties)
     */
    @Deprecated
    public DadataClientBuilder timeout(Duration timeout) {
        this.clientProperties.setTimeout(timeout);
        return this;
    }

    /**
     * @see DadataClientBuilder#clientProperties(DadataClientProperties)
     */
    @Deprecated
    public DadataClientBuilder token(String token) {
        this.clientProperties.setToken(token);
        return this;
    }

    /**
     * @see DadataClientBuilder#clientProperties(DadataClientProperties)
     */
    @Deprecated
    public DadataClientBuilder baseUrl(String baseUrl) {
        this.clientProperties.setBaseUrl(baseUrl);
        return this;
    }

    /**
     * @see DadataClientBuilder#clientProperties(DadataClientProperties)
     */
    @Deprecated
    public DadataClientBuilder maxInMemorySize(DataSize maxInMemorySize) {
        this.clientProperties.setMaxInMemorySize(maxInMemorySize);
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

        ObjectMapper mapper = Jackson2ObjectMapperBuilder.json()
                .visibility(PropertyAccessor.CREATOR, Visibility.NON_PRIVATE)
                .build();
        WebClient client = WebClient.builder()
                .clientConnector(new ReactorClientHttpConnector(buildClient()))
                .baseUrl(clientProperties.getBaseUrl())
                .defaultHeader(HttpHeaders.AUTHORIZATION, "Token " + clientProperties.getToken())
                .codecs(codecs -> {
                    codecs.defaultCodecs().jackson2JsonDecoder(new Jackson2JsonDecoder(mapper));
                    codecs.defaultCodecs().maxInMemorySize(toIntExact(clientProperties.getMaxInMemorySize().toBytes()));
                })
                .build();
        return new DadataClient(client);
    }

    private HttpClient buildClient() {
        TcpClient tcpClient = TcpClient.create()
                .doOnConnected(con -> con.addHandlerLast(
                        new ReadTimeoutHandler(clientProperties.getTimeout().toMillis(),
                                TimeUnit.MILLISECONDS)));

        if (clientProperties.getProxyType() != null && clientProperties.getProxyServer() != null && clientProperties.getProxyPort() != null) {
            ProxyProvider.Proxy proxyType = ProxyProvider.Proxy.valueOf(clientProperties.getProxyType().toUpperCase());
            tcpClient.proxy(typeSpec -> {
                ProxyProvider.Builder builder = typeSpec.type(proxyType)
                        .address(new InetSocketAddress(clientProperties.getProxyServer(), clientProperties.getProxyPort()));

                if (proxyType.equals(ProxyProvider.Proxy.HTTP)) {
                    ofNullable(System.getProperty(PROP_HTTP_USERNAME)).ifPresent(auth ->
                            builder.username(System.getProperty(PROP_HTTP_USERNAME))
                                    .password((username) -> System.getProperty(PROP_HTTP_PASSWORD)));
                } else {
                    ofNullable(System.getProperty(PROP_SOCKS_USERNAME)).ifPresent(auth ->
                            builder.username(System.getProperty(PROP_SOCKS_USERNAME))
                                    .password((username) -> System.getProperty(PROP_SOCKS_PASSWORD)));
                }
            });
        }

        if (!clientProperties.isVerifySsl()) {
            tcpClient.secure(sslContextSpec -> sslContextSpec.sslContext(SslContextBuilder.forClient()
                    .trustManager(InsecureTrustManagerFactory.INSTANCE)));
        }

        return HttpClient.from(tcpClient);
    }
}
