package com.kuliginstepan.dadata.client.domain.organization;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.kuliginstepan.dadata.client.domain.AdditionalProps;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;

/**
 * @see <a href="https://dadata.ru/api/clean/phone/">Dadata phone object</a>
 */

@Value
@Builder
@EqualsAndHashCode(callSuper = true)
public class Phone extends AdditionalProps {

    String source;
    String type;
    @JsonAlias("phone")
    String phoneNumber;
    @JsonAlias("country_code")
    String countryCode;
    @JsonAlias("city_code")
    String cityCode;
    String number;
    String extension;
    String provider;
    String country;
    String region;
    String city;
    String timezone;
    @JsonAlias("qc_conflict")
    String qcConflict;
    String qc;

}
