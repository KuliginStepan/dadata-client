package com.kuliginstepan.dadata.client.domain.organization;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.kuliginstepan.dadata.client.domain.OrganizationStatus;
import com.kuliginstepan.dadata.client.json.LocalDateDeserializer;
import java.time.LocalDate;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class State {

    @JsonAlias("actuality_date")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    LocalDate actualityDate;
    @JsonAlias("registration_date")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    LocalDate registrationDate;
    @JsonAlias("liquidation_date")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    LocalDate liquidationDate;
    String code;
    OrganizationStatus status;
}
