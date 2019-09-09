package com.kuliginstepan.dadata.client.domain.fms;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;

public class UnitTypeSerializer extends JsonSerializer<UnitType> {

    @Override
    public void serialize(UnitType value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeString(String.valueOf(value.ordinal()));
    }
}
