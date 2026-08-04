package com.kuliginstepan.dadata.client.json;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import tools.jackson.core.JsonParser;
import tools.jackson.databind.DeserializationContext;
import tools.jackson.databind.ValueDeserializer;

public class LocalDateDeserializer extends ValueDeserializer<LocalDate> {

    @Override
    public LocalDate deserialize(JsonParser p, DeserializationContext ctxt) {
        long epochMillis = p.getLongValue();
        return Instant.ofEpochMilli(epochMillis).atZone(ZoneId.of("UTC")).toLocalDate();
    }
}
