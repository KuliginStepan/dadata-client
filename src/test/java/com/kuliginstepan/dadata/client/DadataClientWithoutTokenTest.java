package com.kuliginstepan.dadata.client;

import org.junit.Test;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.boot.SpringApplication;

public class DadataClientWithoutTokenTest {

    @Test(expected = BeanCreationException.class)
    public void contextStartFailsIfNoTokenSupplied() {
        SpringApplication.run(TestSpringBootApplication.class);
    }
}
