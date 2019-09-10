package com.kuliginstepan.dadata.client.domain.court;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.kuliginstepan.dadata.client.domain.AdditionalProps;
import lombok.EqualsAndHashCode;
import lombok.Value;

/**
 * @see <a href="https://dadata.ru/api/suggest/region_court/">Courts docs</a>
 */

@EqualsAndHashCode(callSuper = true)
@Value
public class Court extends AdditionalProps {

    private String code;
    private String name;
    @JsonAlias("region_code")
    private String regionCode;
}
