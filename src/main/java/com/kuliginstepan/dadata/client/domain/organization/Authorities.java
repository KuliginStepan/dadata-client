package com.kuliginstepan.dadata.client.domain.organization;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Authorities {

    @JsonAlias("fts_registration")
    Authority ftsRegistration;
    @JsonAlias("fts_report")
    Authority ftsReport;
    Authority pf;
    Authority sif;


    @Value
    @Builder
    public static class Authority {

        String type;
        String code;
        String name;
        String address;
    }
}
