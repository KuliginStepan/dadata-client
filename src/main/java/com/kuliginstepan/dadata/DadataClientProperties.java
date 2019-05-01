package com.kuliginstepan.dadata;

import java.time.Duration;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "dadata.client")
@Data
public class DadataClientProperties {

    /**
     * Dadata API token
     */
    private String token;

    /**
     * Request timeout
     */
    private Duration timeout;
}
