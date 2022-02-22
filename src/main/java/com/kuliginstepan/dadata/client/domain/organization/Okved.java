package com.kuliginstepan.dadata.client.domain.organization;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class Okved {

    Boolean main;
    String type;
    String code;
    String name;
}
