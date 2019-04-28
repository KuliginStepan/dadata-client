package com.kuliginstepan.dadata;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kuliginstepan.dadata.domain.Address;
import com.kuliginstepan.dadata.exception.DadataException;
import com.kuliginstepan.dadata.domain.DadataResponse.Suggestion;
import org.junit.Assert;
import org.junit.Test;

public class DadataApplicationTests {

    DadataClient client = new DadataClient("d0a06c568347cb09905d9a0fe9009380eb6b25d3");

    @Test
    public void name() {
        Suggestion<Address> address = client.findAddress("москва хабар").block();
        Assert.assertEquals("г Москва, ул Хабаровская", address.getValue());
        Assert.assertEquals("0c5b2444-70a0-4932-980c-b4dc0d3f02b5", address.getData().getCityFiasId());
        Assert.assertEquals("77000000000713400", address.getData().getKladrId());
    }

    @Test(expected = DadataException.class)
    public void name2() {
        DadataClient client = new DadataClient("123456");
        client.findAddress("москва хабар").block();
    }



    @Test
    public void name1() throws JsonProcessingException {
        Suggestion<Address> addressSuggestion = client.findAddressById("32fcb102-2a50-44c9-a00e-806420f448ea").block();
    }
}
