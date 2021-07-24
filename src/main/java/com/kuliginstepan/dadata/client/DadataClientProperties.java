package com.kuliginstepan.dadata.client;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.util.unit.DataSize;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

@ConfigurationProperties(prefix = "dadata.client")
@Data
public class DadataClientProperties {

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
     * Proxy server type
     */
    private String proxyType;

    /**
     * Proxy server address
     */
    private String proxyServer;

    /**
     * Proxy server port
     */
    private Integer proxyPort;

    /**
     * SSL verification option
     */
    private boolean verifySsl = true;
}
