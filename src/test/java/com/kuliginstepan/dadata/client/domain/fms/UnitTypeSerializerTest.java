package com.kuliginstepan.dadata.client.domain.fms;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.StringWriter;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import tools.jackson.core.JsonGenerator;
import tools.jackson.core.ObjectWriteContext;
import tools.jackson.core.json.JsonFactory;

@JsonTest
@ExtendWith(SpringExtension.class)
public class UnitTypeSerializerTest {

    @Autowired
    private JacksonTester<Map<String, UnitType>> json;

    @Test
    public void shouldDeserializeFromOrdinal() throws Exception {
        json.parse("{\"type\": 0}").assertThat().asMap().containsValue(UnitType.FMS);
    }

    @Test
    public void shouldSerializeToOrdinal() throws Exception {
        UnitType unitType = UnitType.FMS;

        StringWriter out = new StringWriter();
        JsonGenerator jsonGenerator = new JsonFactory().createGenerator(ObjectWriteContext.empty(), out);
        UnitTypeSerializer serializer = new UnitTypeSerializer();

        serializer.serialize(unitType, jsonGenerator, null);
        jsonGenerator.flush();

        assertEquals("\"" + unitType.ordinal() + "\"", out.toString());
    }

}
