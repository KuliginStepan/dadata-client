package com.kuliginstepan.dadata.client.domain.organization;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class Opf {

    String type;
    String code;
    @JsonAlias("full")
    String fullName;
    @JsonAlias("short")
    String shortName;
}
