package com.kuliginstepan.dadata.client;

import static java.lang.Math.toIntExact;
import static java.util.Optional.ofNullable;

import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;
import io.netty.handler.timeout.ReadTimeoutHandler;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.springframework.http.HttpHeaders;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.util.unit.DataSize;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;
import reactor.netty.tcp.TcpClient;
import reactor.netty.transport.ProxyProvider;

public class DadataClientBuilder {

    private static final Map<ProxyProvider.Proxy, PasswordAuthentication> proxyAuthProps = new HashMap<ProxyProvider.Proxy, PasswordAuthentication>() {{
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

    /**
     * @param timeout таймаут соединения
     * @return билдер Dadata-клиента
     * @see DadataClientBuilder#clientProperties(DadataClientProperties)
     */
    @Deprecated
    public DadataClientBuilder timeout(Duration timeout) {
        this.clientProperties.setTimeout(timeout);
        return this;
    }

    /**
     * @param token токен доступа к API Dadata
     * @return билдер Dadata-клиента
     * @see DadataClientBuilder#clientProperties(DadataClientProperties)
     */
    @Deprecated
    public DadataClientBuilder token(String token) {
        this.clientProperties.setToken(token);
        return this;
    }

    /**
     * @param baseUrl базовый URL Dadata API
     * @return билдер Dadata-клиента
     * @see DadataClientBuilder#clientProperties(DadataClientProperties)
     */
    @Deprecated
    public DadataClientBuilder baseUrl(String baseUrl) {
        this.clientProperties.setBaseUrl(baseUrl);
        return this;
    }

    /**
     * @param maxInMemorySize размер буфера при обработке ответа от Dadata
     * @return билдер Dadata-клиента
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
        TcpClient tcpClient = TcpClient.create()
            .doOnConnected(con -> con.addHandlerLast(
                new ReadTimeoutHandler(clientProperties.getTimeout().toMillis(),
                    TimeUnit.MILLISECONDS)));

        DadataClientProperties.ProxyProperties proxyProperties = clientProperties.getProxy();
        if (proxyProperties != null) {
            tcpClient = tcpClient.proxy(typeSpec -> {
                ProxyProvider.Builder builder = typeSpec.type(proxyProperties.getType())
                    .address(new InetSocketAddress(proxyProperties.getServer(), proxyProperties.getPort()));

                PasswordAuthentication authProps = proxyAuthProps.get(proxyProperties.getType());

                ofNullable(System.getProperty(authProps.getUserName())).ifPresent(username ->
                    builder.username(username)
                        .password((auth) -> System.getProperty(String.valueOf(authProps.getPassword()))));
            });
        }

        if (!clientProperties.isVerifySsl()) {
            tcpClient = tcpClient.secure(sslContextSpec -> sslContextSpec.sslContext(SslContextBuilder.forClient()
                .trustManager(InsecureTrustManagerFactory.INSTANCE)));
        }

        return HttpClient.from(tcpClient);
    }
}
