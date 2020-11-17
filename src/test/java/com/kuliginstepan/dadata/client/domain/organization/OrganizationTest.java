package com.kuliginstepan.dadata.client.domain.organization;

import java.io.IOException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.core.io.ClassPathResource;

@JsonTest
class OrganizationTest {

    @Autowired
    JacksonTester<Organization> json;

    @Test
    void shouldDeserializeFromJson() throws IOException {
        json.read(new ClassPathResource("organization.json"))
            .assertThat()
            .extracting(Organization::getCapital)
            .isNotNull();
    }
}