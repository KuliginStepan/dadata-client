package com.kuliginstepan.dadata.client.domain.organization;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.kuliginstepan.dadata.client.domain.AdditionalProps;
import com.kuliginstepan.dadata.client.domain.OrganizationStatus;
import com.kuliginstepan.dadata.client.domain.Suggestion;
import com.kuliginstepan.dadata.client.domain.address.Address;
import com.kuliginstepan.dadata.client.domain.fio.Fio;
import com.kuliginstepan.dadata.client.json.LocalDateDeserializer;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;

/**
 * @see <a href="https://confluence.hflabs.ru/pages/viewpage.action?pageId=204669126">Dadata organization object</a>
 */

@Value
@Builder
@EqualsAndHashCode(callSuper = true)
public class Organization extends AdditionalProps {

    Suggestion<Address> address;
    String source;
    String qc;
    @JsonAlias("branch_count")
    Integer branchCount;
    @JsonAlias("branch_type")
    BranchType branchType;
    String inn;
    String kpp;
    String ogrn;
    @JsonAlias("ogrn_date")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    LocalDate ogrnDate;
    String hid;
    Management management;
    Name name;
    String okato;
    String oktmo;
    String okpo;
    String okogu;
    String okfs;
    Finance finance;
    String okved;
    @JsonAlias("okved_type")
    String okvedType;
    Opf opf;
    State state;
    OrganizationType type;
    @JsonAlias("employee_count")
    Integer employeeCount;

    List<Okved> okveds;
    Authorities authorities;
    Citizenship citizenship;

    List<Founder> founders;
    List<Manager> managers;
    List<Entity> predecessors;
    List<Entity> successors;
    Capital capital;
    Documents documents;
    List<License> licenses;

    List<String> phones;
    List<String> emails;

    @Value
    @Builder
    public static class Entity {

        String ogrn;
        String inn;
        String name;
    }

    @Value
    @Builder
    public static class License {

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

    @Value
    @Builder
    public static class Documents {

        @JsonAlias("fts_registration")
        Document ftsRegistration;
        @JsonAlias("pf_registration")
        Document pfRegistration;
        @JsonAlias("sif_registration")
        Document sifRegistration;
        Smb smb;

        @Value
        @Builder
        public static class Smb {

            String type;
            Category category;
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

    @Value
    @Builder
    public static class Finance {

        @JsonAlias("tax_system")
        TaxSystem taxSystem;
        BigDecimal income;
        BigDecimal expense;
        BigDecimal debt;
        BigDecimal penalty;

        public enum TaxSystem {

            ENVD,
            ESHN,
            SRP,
            USN,
            ENVD_ESHN,
            USN_ENVD
        }

    }

    @Value
    @Builder
    public static class Manager {

        String ogrn;
        String inn;
        String name;
        Fio fio;
        String post;
        String hid;
        ManagerType type;

        public enum ManagerType {

            EMPLOYEE,
            FOREIGNER,
            LEGAL
        }
    }

    @Value
    @Builder
    public static class Founder {

        String ogrn;
        String inn;
        String name;
        Fio fio;
        String hid;
        FounderType type;
        Share share;

        public enum FounderType {

            LEGAL,
            PHYSICAL
        }

        @Value
        @Builder
        public static class Share {

            Type type;
            Double value;
            Double numerator;
            Double denominator;

            public enum Type {

                PERCENT,
                DECIMAL,
                FRACTION
            }
        }
    }

    @Value
    @Builder
    public static class Capital {

        String type;
        BigDecimal value;
    }

    @Value
    @Builder
    public static class Citizenship {

        Code code;
        Name name;

        @Value
        @Builder
        public static class Code {

            String numeric;
            @JsonAlias("alpha_3")
            String alpha3;
        }

        @Value
        @Builder
        public static class Name {

            String full;
            @JsonAlias("short")
            String shortName;
        }
    }

    @Value
    @Builder
    public static class Authorities {

        @JsonAlias("fts_registration")
        Authority ftsRegistration;
        @JsonAlias("fts_report")
        Authority ftsReport;
        Authority pf;
        Authority sif;

    }

    @Value
    @Builder
    public static class Authority {

        String type;
        String code;
        String name;
        String address;
    }


    @Value
    @Builder
    public static class Management {

        String name;
        String post;
        Boolean disqualified;
    }

    @Value
    @Builder
    public static class State {

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

    @Value
    @Builder
    public static class Opf {

        String type;
        String code;
        @JsonAlias("full")
        String fullName;
        @JsonAlias("short")
        String shortName;
    }

    @Value
    @Builder
    public static class Name {

        @JsonAlias("full_with_opf")
        String fullWithOpf;
        @JsonAlias("short_with_opf")
        String shortWithOpf;
        String latin;
        /**
         * @deprecated Will be deleted at 2021. Use {@link #fullWithOpf} instead
         */
        @JsonAlias("full")
        @Deprecated
        String fullName;
        /**
         * @deprecated Will be deleted at 2021. Use {@link #shortWithOpf} instead
         */
        @JsonAlias("short")
        @Deprecated
        String shortName;
    }

    @Value
    @Builder
    public static class Okved {

        Boolean main;
        String type;
        String code;
        String name;
    }
}
