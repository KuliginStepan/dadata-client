package com.kuliginstepan.dadata.client.domain.court;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.kuliginstepan.dadata.client.domain.AdditionalProps;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;

/**
 * @see <a href="https://dadata.ru/api/suggest/region_court/">Courts docs</a>
 */

@Value
@Builder
@EqualsAndHashCode(callSuper = true)
public class Court extends AdditionalProps {

    String code;
    String name;
    @JsonAlias("region_code")
    String regionCode;
}
