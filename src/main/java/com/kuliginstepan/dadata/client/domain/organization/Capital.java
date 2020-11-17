package com.kuliginstepan.dadata.client.domain.organization;

import java.math.BigDecimal;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Capital {

    String type;
    BigDecimal value;
}
