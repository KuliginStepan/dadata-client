package com.kuliginstepan.dadata.client;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
@EnableConfigurationProperties(DadataClientProperties.class)
public class DadataClientAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean(DadataClient.class)
    public DadataClient dadataClient(DadataClientProperties clientProperties) {
        return new DadataClientBuilder()
            .clientProperties(clientProperties)
            .build();
    }
}
