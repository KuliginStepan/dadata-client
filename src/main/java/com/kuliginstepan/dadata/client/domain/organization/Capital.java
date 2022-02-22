package com.kuliginstepan.dadata.client.domain.organization;

import java.math.BigDecimal;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class Capital {

    String type;
    BigDecimal value;
}
