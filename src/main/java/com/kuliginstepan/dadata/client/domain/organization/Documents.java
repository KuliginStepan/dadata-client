package com.kuliginstepan.dadata.client.domain.organization;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.kuliginstepan.dadata.client.json.LocalDateDeserializer;
import java.time.LocalDate;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class Documents {

    @JsonAlias("fts_registration")
    Document ftsRegistration;
    @JsonAlias("pf_registration")
    Document pfRegistration;
    @JsonAlias("sif_registration")
    Document sifRegistration;
    Smb smb;

    @Value
    @Builder
    @Jacksonized
    public static class Smb {

        String type;
        Smb.Category category;
        @JsonAlias("issue_date")
        @JsonDeserialize(using = LocalDateDeserializer.class)
        LocalDate issueDate;

        public enum Category {

            MICRO,
            SMALL,
            MEDIUM
        }
    }

    @Value
    @Builder
    @Jacksonized
    public static class Document {

        String type;
        String series;
        String number;
        @JsonAlias("issue_date")
        @JsonDeserialize(using = LocalDateDeserializer.class)
        LocalDate issueDate;
        @JsonAlias("issue_authority")
        String issueAuthority;
    }
}
