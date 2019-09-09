package com.kuliginstepan.dadata.client.domain.fms;

import java.io.IOException;
import java.util.Map;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.junit4.SpringRunner;

@JsonTest
@RunWith(SpringRunner.class)
public class UnitTypeSerializerTest {

    @Autowired
    private JacksonTester<Map<String, UnitType>> json;

    @Test
    public void shouldSerializeFromOrdinal() throws IOException {
        json.parse("{\"type\": 0}").assertThat().asMap().containsValue(UnitType.FMS);
    }
}