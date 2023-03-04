package com.kuliginstepan.dadata.client;

import jakarta.validation.constraints.NotNull;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.util.unit.DataSize;
import org.springframework.validation.annotation.Validated;
import reactor.netty.transport.ProxyProvider;

@Data
@Validated
@ConfigurationProperties(prefix = "dadata.client")
public class DadataClientProperties {

    @Data
    @NoArgsConstructor
    public static class ProxyProperties {
        /**
         * Proxy server type, defaults to HTTP
         */
        @NotNull
        private ProxyProvider.Proxy type = ProxyProvider.Proxy.HTTP;

        /**
         * Proxy server address
         */
        @NotNull
        private String server;

        /**
         * Proxy server port
         */
        @NotNull
        private Integer port;
    }

    /**
     * Dadata base url
     */
    private String baseUrl = "https://suggestions.dadata.ru/suggestions/api/4_1/rs";

    /**
     * Dadata API token
     */
    private String token;

    /**
     * Request timeout. Default - 5 seconds
     */
    private Duration timeout = Duration.of(5, ChronoUnit.SECONDS);

    /**
     * Maximum byte buffer size. Default - 512 Kb
     */
    private DataSize maxInMemorySize = DataSize.ofKilobytes(512L);

    /**
     * Proxy properties
     */
    private ProxyProperties proxy;

    /**
     * SSL verification option
     */
    private boolean verifySsl = true;
}
