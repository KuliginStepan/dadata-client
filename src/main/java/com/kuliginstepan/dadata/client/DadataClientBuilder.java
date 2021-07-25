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
import java.net.PasswordAuthentication;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static java.lang.Math.toIntExact;
import static java.util.Optional.ofNullable;

public class DadataClientBuilder {

    private static final Map<ProxyProvider.Proxy, PasswordAuthentication> proxyAuthProps = new HashMap<ProxyProvider.Proxy, PasswordAuthentication>() {{
        put(ProxyProvider.Proxy.HTTP, new PasswordAuthentication("http.ProxyUser", "http.ProxyPassword".toCharArray()));
        put(ProxyProvider.Proxy.SOCKS4, new PasswordAuthentication("java.net.socks.username", "java.net.socks.password".toCharArray()));
        put(ProxyProvider.Proxy.SOCKS5, new PasswordAuthentication("java.net.socks.username", "java.net.socks.password".toCharArray()));
    }};

    private WebClient webClient;

    private DadataClientProperties clientProperties = new DadataClientProperties();

    public DadataClientBuilder webClient(WebClient webClient) {
        this.webClient = webClient;
        return this;
    }

    /**
     * @see DadataClientBuilder#clientProperties(DadataClientProperties)
     * @param timeout таймаут соединения
     * @return билдер Dadata-клиента
     */
    @Deprecated
    public DadataClientBuilder timeout(Duration timeout) {
        this.clientProperties.setTimeout(timeout);
        return this;
    }

    /**
     * @see DadataClientBuilder#clientProperties(DadataClientProperties)
     * @param token токен доступа к API Dadata
     * @return билдер Dadata-клиента
     */
    @Deprecated
    public DadataClientBuilder token(String token) {
        this.clientProperties.setToken(token);
        return this;
    }

    /**
     * @see DadataClientBuilder#clientProperties(DadataClientProperties)
     * @param baseUrl базовый URL Dadata API
     * @return билдер Dadata-клиента
     */
    @Deprecated
    public DadataClientBuilder baseUrl(String baseUrl) {
        this.clientProperties.setBaseUrl(baseUrl);
        return this;
    }

    /**
     * @see DadataClientBuilder#clientProperties(DadataClientProperties)
     * @param maxInMemorySize размер буфера при обработке ответа от Dadata
     * @return билдер Dadata-клиента
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
                .clientConnector(new ReactorClientHttpConnector(buildHttpClient()))
                .baseUrl(clientProperties.getBaseUrl())
                .defaultHeader(HttpHeaders.AUTHORIZATION, "Token " + clientProperties.getToken())
                .codecs(codecs -> {
                    codecs.defaultCodecs().jackson2JsonDecoder(new Jackson2JsonDecoder(mapper));
                    codecs.defaultCodecs().maxInMemorySize(toIntExact(clientProperties.getMaxInMemorySize().toBytes()));
                })
                .build();
        return new DadataClient(client);
    }

    private HttpClient buildHttpClient() {
        TcpClient tcpClient = TcpClient.create()
                .doOnConnected(con -> con.addHandlerLast(
                        new ReadTimeoutHandler(clientProperties.getTimeout().toMillis(),
                                TimeUnit.MILLISECONDS)));

        if (clientProperties.getProxyType() != null && clientProperties.getProxyServer() != null && clientProperties.getProxyPort() != null) {
            tcpClient = tcpClient.proxy(typeSpec -> {
                ProxyProvider.Builder builder = typeSpec.type(clientProperties.getProxyType())
                        .address(new InetSocketAddress(clientProperties.getProxyServer(), clientProperties.getProxyPort()));

                PasswordAuthentication authProps = proxyAuthProps.get(clientProperties.getProxyType());

                ofNullable(System.getProperty(authProps.getUserName())).ifPresent(username ->
                        builder.username(System.getProperty(username))
                                .password((auth) -> System.getProperty(Arrays.toString(authProps.getPassword()))));
            });
        }

        if (!clientProperties.isVerifySsl()) {
            tcpClient = tcpClient.secure(sslContextSpec -> sslContextSpec.sslContext(SslContextBuilder.forClient()
                    .trustManager(InsecureTrustManagerFactory.INSTANCE)));
        }

        return HttpClient.from(tcpClient);
    }
}
