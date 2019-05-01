package com.kuliginstepan.dadata.client.domain.address;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum FilterProperty {

    @JsonProperty("country")
    COUNTRY,
    @JsonProperty("kladr_id")
    KLADR_ID,
    @JsonProperty("postal_code")
    POSTAL_CODE,
    @JsonProperty("region")
    REGION,
    @JsonProperty("region_fias_id")
    REGION_FIAS_ID,
    @JsonProperty("region_type_full")
    REGION_TYPE_FULL,
    @JsonProperty("area")
    AREA,
    @JsonProperty("area_fias_id")
    AREA_FIAS_ID,
    @JsonProperty("area_type_full")
    AREA_TYPE_FULL,
    @JsonProperty("city")
    CITY,
    @JsonProperty("city_fias_id")
    CITY_FIAS_ID,
    @JsonProperty("city_type_full")
    CITY_TYPE_FULL,
    @JsonProperty("settlement")
    SETTLEMENT,
    @JsonProperty("settlement_fias_id")
    SETTLEMENT_FIAS_ID,
    @JsonProperty("settlement_type_full")
    SETTLEMENT_TYPE_FULL,
    @JsonProperty("street")
    STREET,
    @JsonProperty("street_fias_id")
    STREET_FIAS_ID,
    @JsonProperty("street_type_full")
    STREET_TYPE_FULL
}
