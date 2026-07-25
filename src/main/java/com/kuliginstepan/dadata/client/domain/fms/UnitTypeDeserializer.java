package com.kuliginstepan.dadata.client.domain.fms;

import tools.jackson.core.JsonParser;
import tools.jackson.databind.DeserializationContext;
import tools.jackson.databind.ValueDeserializer;

public class UnitTypeDeserializer extends ValueDeserializer<UnitType> {

    @Override
    public UnitType deserialize(JsonParser p, DeserializationContext ctxt) {
        return UnitType.values()[Integer.parseInt(p.getString())];
    }
}
