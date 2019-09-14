package com.kuliginstepan.dadata.client;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.reactive.function.client.WebClient;

@RunWith(SpringRunner.class)
@SpringBootTest
@Import(DadataClientWithWebClientTest.TestConfig.class)
@DirtiesContext
public class DadataClientWithWebClientTest {

    public static class TestConfig {

        @Bean
        public DadataClient client() {
            return new DadataClientBuilder().webClient(WebClient.builder().build()).build();
        }
    }

    @Autowired
    DadataClient client;

    @Test
    public void contextLoadsWhenOnlyWebClientSpecified() {

    }

}
