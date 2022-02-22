package com.kuliginstepan.dadata.client.domain.court;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.kuliginstepan.dadata.client.domain.AdditionalProps;
import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * @see <a href="https://dadata.ru/api/suggest/region_court/">Courts docs</a>
 */

@Value
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@Jacksonized
public class Court extends AdditionalProps {

    String code;
    String name;
    @JsonAlias("region_code")
    String regionCode;
}
