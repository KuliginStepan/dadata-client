package com.kuliginstepan.dadata.client;

import io.netty.handler.timeout.ReadTimeoutException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = {"dadata.client.token=d0a06c568347cb09905d9a0fe9009380eb6b25d3",
    "dadata.client.timeout=10ms"})
@DirtiesContext
public class DadataClientWithTimeoutAutoConfigurationTest {

    @Autowired
    DadataClient client;

    @Test(expected = ReadTimeoutException.class)
    public void contextLoads() {
        client.findAddressById("").block();
    }
}