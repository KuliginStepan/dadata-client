package com.kuliginstepan.dadata.client;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.reactive.function.client.WebClient;

public class DadataClientBuilderTest {

    @Test(expected = IllegalArgumentException.class)
    public void shouldFailsWithoutToken() {
        DadataClient client = new DadataClientBuilder().build();
    }

    @Test(expected = NullPointerException.class)
    public void shouldFailsIncorrectProxy() {
        DadataClientProperties properties = new DadataClientProperties();
        properties.setToken(TestUtils.TOKEN);
        properties.setProxy(new DadataClientProperties.ProxyProperties());
        DadataClient client = new DadataClientBuilder().clientProperties(properties).build();
    }

    @Test
    public void shouldUseProvidedWebClient() {
        WebClient webClient = WebClient.create();
        DadataClient client = new DadataClientBuilder().webClient(webClient).build();
        Object webClient1 = ReflectionTestUtils.getField(client, "webClient");
        assertThat(webClient).isEqualTo(webClient1);
    }
}