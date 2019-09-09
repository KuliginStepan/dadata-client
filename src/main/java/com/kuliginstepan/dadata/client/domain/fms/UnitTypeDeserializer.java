package com.kuliginstepan.dadata.client.domain.fms;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;

public class UnitTypeDeserializer extends JsonDeserializer<UnitType> {

    @Override
    public UnitType deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        return UnitType.values()[Integer.parseInt(p.getText())];
    }
}
