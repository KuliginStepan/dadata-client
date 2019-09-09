package com.kuliginstepan.dadata.client.domain.fms;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Builder;
import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
@Builder
public class FmsUnitFilter {

    /**
     * first 2 digits of region kladr code
     */
    @JsonProperty("region_code")
    private String regionCode;
    @JsonSerialize(using = UnitTypeSerializer.class)
    private UnitType type;

}
