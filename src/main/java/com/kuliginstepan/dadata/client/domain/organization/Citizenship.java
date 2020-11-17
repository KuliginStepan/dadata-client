package com.kuliginstepan.dadata.client.domain.organization;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Citizenship {

    Code code;
    Name name;

    @Value
    @Builder
    public static class Code {

        String numeric;
        @JsonAlias("alpha_3")
        String alpha3;
    }

    @Value
    @Builder
    public static class Name {

        String full;
        @JsonAlias("short")
        String shortName;
    }
}
