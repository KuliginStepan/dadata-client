package com.kuliginstepan.dadata.domain.organization;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.kuliginstepan.dadata.domain.Suggestion;
import com.kuliginstepan.dadata.domain.address.Address;
import com.kuliginstepan.dadata.json.LocalDateDeserializer;
import java.time.LocalDate;
import java.util.List;
import lombok.Data;

@Data
public class Organization {

    private String kpp;
    private Double capital;
    private Management management;
    private List<String> founders;
    private List<String> managers;
    @JsonAlias("branch_type")
    private String branchType;
    @JsonAlias("branch_count")
    private Integer branchCount;
    private String source;
    private String qc;
    private String hid;
    private State state;
    private Opf opf;
    private Name name;
    private String inn;
    private String ogrn;
    private String okpo;
    private String okved;
    private List<String> okveds;
    private String authorities;
    private String documents;
    private List<String> licenses;
    private Suggestion<Address> address;
    private List<String> phones;
    private List<String> emails;
    @JsonAlias("ogrn_date")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate ogrnDate;
    @JsonAlias("okved_type")
    private String okvedType;


    @Data
    public static class Management {

        private String name;
        private String post;
    }

    @Data
    public static class State {

        private String status;
        @JsonAlias("actuality_date")
        @JsonDeserialize(using = LocalDateDeserializer.class)
        private LocalDate actualityDate;
        @JsonAlias("registration_date")
        @JsonDeserialize(using = LocalDateDeserializer.class)
        private LocalDate registrationDate;
        @JsonAlias("liquidation_date")
        @JsonDeserialize(using = LocalDateDeserializer.class)
        private LocalDate liquidationDate;
    }

    @Data
    public static class Opf {

        private String type;
        private String code;
        @JsonAlias("full")
        private String fullName;
        @JsonAlias("short")
        private String shortName;
    }

    @Data
    public static class Name {

        @JsonAlias("full_with_opf")
        private String fullWithOpf;
        @JsonAlias("short_with_opf")
        private String shortWithOpf;
        private String latin;
        @JsonAlias("full")
        private String fullName;
        @JsonAlias("short")
        private String shortName;
    }
}
