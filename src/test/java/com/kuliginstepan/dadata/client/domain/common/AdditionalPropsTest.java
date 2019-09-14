package com.kuliginstepan.dadata.client.domain.common;

import static org.junit.Assert.assertEquals;

import com.kuliginstepan.dadata.client.domain.address.Address;
import java.io.IOException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.junit4.SpringRunner;

@JsonTest
@RunWith(SpringRunner.class)
public class AdditionalPropsTest {

    @Autowired
    private JacksonTester<Address> json;

    @Test
    public void shoudSerializeUnknownFieldToAdditionalProps() throws IOException {
        Address address = json.parseObject("{\"country\": \"RU\", \"other_field\": 123}");
        assertEquals("RU", address.getCountry());
        assertEquals(123, address.getAdditionalProperties().get("other_field"));
    }

}
