package com.kuliginstepan.dadata.client;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

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
     * Maximum byte buffer size. Default - 256 Kb
     */
    private Integer maxInMemorySize = 256 * 1024;
}
