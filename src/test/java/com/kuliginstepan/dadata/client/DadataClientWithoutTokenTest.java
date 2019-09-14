package com.kuliginstepan.dadata.client;

import org.junit.Test;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.boot.SpringApplication;
import org.springframework.test.annotation.DirtiesContext;

public class DadataClientWithoutTokenTest {

    @Test(expected = BeanCreationException.class)
    @DirtiesContext
    public void contextStartFailsIfNoTokenSupplied() {
        SpringApplication.run(TestSpringBootApplication.class);
    }
}
