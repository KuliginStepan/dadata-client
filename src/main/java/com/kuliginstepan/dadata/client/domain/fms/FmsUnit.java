package com.kuliginstepan.dadata.client.domain.fms;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.kuliginstepan.dadata.client.domain.AdditionalProps;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;

/**
 * @see <a href="https://dadata.ru/api/suggest/fms_unit/">FMS Unit docs</a>
 */

@Value
@Builder
@EqualsAndHashCode(callSuper = true)
public class FmsUnit extends AdditionalProps {

    String code;
    String name;
    @JsonAlias("region_code")
    String regionCode;
    @JsonDeserialize(using = UnitTypeDeserializer.class)
    UnitType type;
}
