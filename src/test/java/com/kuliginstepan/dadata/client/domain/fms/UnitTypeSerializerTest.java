package com.kuliginstepan.dadata.client.domain.fms;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;

@JsonTest
@RunWith(SpringRunner.class)
public class UnitTypeSerializerTest {

    @Autowired
    private JacksonTester<Map<String, UnitType>> json;

    @Test
    public void shouldDeserializeFromOrdinal() throws IOException {
        json.parse("{\"type\": 0}").assertThat().asMap().containsValue(UnitType.FMS);
    }

    @Test
    public void shouldSerializeToOrdinal() throws IOException {
        UnitType unitType = UnitType.FMS;

        StringWriter out = new StringWriter();
        JsonFactory jsonFactory = new JsonFactory();
        JsonGenerator jsonGenerator = jsonFactory.createGenerator(out);
        UnitTypeSerializer serializer = new UnitTypeSerializer();

        serializer.serialize(unitType, jsonGenerator, any(SerializerProvider.class));
        jsonGenerator.flush();

        assertEquals("\"" + unitType.ordinal() + "\"", out.toString());
    }

}