package com.kuliginstepan.dadata.client.domain.fms;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;

@Data
public class FmsUnit {

    private String code;
    private String name;
    @JsonAlias("region_code")
    private String regionCode;
    @JsonDeserialize(using = UnitTypeDeserializer.class)
    private UnitType type;
}
