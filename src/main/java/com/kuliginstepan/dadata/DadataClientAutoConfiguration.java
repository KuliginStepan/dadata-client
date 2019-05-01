package com.kuliginstepan.dadata;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(DadataClientProperties.class)
public class DadataClientAutoConfiguration {

    @Bean
    public DadataClient dadataClient(DadataClientProperties dadataClientProperties) {
        if (dadataClientProperties.getTimeout() == null) {
            return new DadataClient(dadataClientProperties.getToken());
        } else {
            return new DadataClient(dadataClientProperties.getToken(), dadataClientProperties.getTimeout());
        }
    }
}
