package com.kuliginstepan.dadata.client.domain.organization;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Entity {

    String ogrn;
    String inn;
    String name;
}
