package com.kuliginstepan.dadata.client.domain.organization;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Management {

    String name;
    String post;
    Boolean disqualified;
}
