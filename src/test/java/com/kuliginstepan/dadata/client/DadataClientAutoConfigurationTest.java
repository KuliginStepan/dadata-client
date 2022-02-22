package com.kuliginstepan.dadata.client;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(properties = "dadata.client.token=d0a06c568347cb09905d9a0fe9009380eb6b25d3")
public class DadataClientAutoConfigurationTest {

    @Autowired
    DadataClient client;

    @Test
    public void contextLoads() {
        client.findAddressById("").block();
    }
}