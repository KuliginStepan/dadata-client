package com.kuliginstepan.dadata.client.domain.organization;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Okved {

    Boolean main;
    String type;
    String code;
    String name;
}
