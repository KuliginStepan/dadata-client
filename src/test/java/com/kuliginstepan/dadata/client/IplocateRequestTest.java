package com.kuliginstepan.dadata.client;

import static com.kuliginstepan.dadata.client.TestUtils.CLIENT;
import static org.assertj.core.api.Assertions.assertThat;

import com.kuliginstepan.dadata.client.domain.Suggestion;
import com.kuliginstepan.dadata.client.domain.address.Address;
import org.junit.jupiter.api.Test;

public class IplocateRequestTest {

    @Test
    public void iplocateTest() {
        Suggestion<Address> suggestion = CLIENT.iplocate("46.226.227.20").block();

        assertThat(suggestion)
            .isNotNull()
            .hasFieldOrPropertyWithValue("value", "г Краснодар");
    }
    @Test
    public void iplocateNullTest() {
        Suggestion<Address> suggestion = CLIENT.iplocate("46.226.227").block();

        assertThat(suggestion)
            .isNull();
    }
}
