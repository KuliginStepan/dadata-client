package com.kuliginstepan.dadata.client.domain.organization;

import com.fasterxml.jackson.annotation.JsonAlias;
import java.math.BigDecimal;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Finance {

    @JsonAlias("tax_system")
    TaxSystem taxSystem;
    BigDecimal income;
    BigDecimal expense;
    BigDecimal debt;
    BigDecimal penalty;
    String year;

    public enum TaxSystem {

        ENVD,
        ESHN,
        SRP,
        USN,
        ENVD_ESHN,
        USN_ENVD
    }

}
