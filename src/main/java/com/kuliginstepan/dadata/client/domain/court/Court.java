package com.kuliginstepan.dadata.client.domain.court;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Value;

/**
 * @see <a href="https://dadata.ru/api/suggest/region_court/">Courts docs</a>
 */

@Value
public class Court {

    private String code;
    private String name;
    @JsonAlias("region_code")
    private String regionCode;
}
