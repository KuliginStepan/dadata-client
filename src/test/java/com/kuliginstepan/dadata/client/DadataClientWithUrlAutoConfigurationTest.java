package com.kuliginstepan.dadata.client;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = {"dadata.client.token=d0a06c568347cb09905d9a0fe9009380eb6b25d3",
    "dadata.client.baseUrl=http://fake-url"})
public class DadataClientWithUrlAutoConfigurationTest {

    @Autowired
    DadataClient client;

    @Test(expected = Exception.class)
    public void shouldFailWithBadBaseUrl() {
        client.findAddressById("").block();
    }

}
