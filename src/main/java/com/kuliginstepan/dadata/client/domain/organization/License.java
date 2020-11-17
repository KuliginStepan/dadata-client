package com.kuliginstepan.dadata.client.domain.organization;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.kuliginstepan.dadata.client.json.LocalDateDeserializer;
import java.time.LocalDate;
import java.util.List;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class License {

    String series;
    String number;
    @JsonAlias("issue_date")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    LocalDate issueDate;
    @JsonAlias("issue_authority")
    String issueAuthority;
    @JsonAlias("suspend_date")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    LocalDate suspendDate;
    @JsonAlias("suspend_authority")
    String suspendAuthority;
    @JsonAlias("valid_from")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    LocalDate validFrom;
    @JsonAlias("valid_to")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    LocalDate validTo;
    List<String> activities;
    List<String> addresses;

}
