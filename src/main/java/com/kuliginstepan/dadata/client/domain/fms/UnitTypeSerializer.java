package com.kuliginstepan.dadata.client.domain.fms;

import tools.jackson.core.JsonGenerator;
import tools.jackson.databind.SerializationContext;
import tools.jackson.databind.ValueSerializer;

public class UnitTypeSerializer extends ValueSerializer<UnitType> {

    @Override
    public void serialize(UnitType value, JsonGenerator gen, SerializationContext ctxt) {
        gen.writeString(String.valueOf(value.ordinal()));
    }
}
