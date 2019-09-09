package com.kuliginstepan.dadata.client.domain.fms;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Value;

/**
 * @see <a href="https://dadata.ru/api/suggest/fms_unit/">FMS Unit docs</a>
 */

@Value
public class FmsUnit {

    private String code;
    private String name;
    @JsonAlias("region_code")
    private String regionCode;
    @JsonDeserialize(using = UnitTypeDeserializer.class)
    private UnitType type;
}
