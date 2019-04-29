package com.kuliginstepan.dadata.domain.bank;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.kuliginstepan.dadata.domain.Suggestion;
import com.kuliginstepan.dadata.domain.address.Address;
import com.kuliginstepan.dadata.domain.organization.Organization.State;
import java.util.List;
import lombok.Data;

@Data
public class Bank {

    private Opf opf;
    private Name name;
    private String bic;
    private String swift;
    private String okpo;
    @JsonAlias("correspondent_account")
    private String correspondentAccount;
    @JsonAlias("registration_number")
    private String registrationNumber;
    private String rkc;
    private Suggestion<Address> address;
    private List<String> phones;
    private State state;

    @Data
    public static class Opf {

        private String type;
        @JsonAlias("full")
        private String fullName;
        @JsonAlias("short")
        private String shortName;
    }

    @Data
    public static class Name {

        private String payment;
        @JsonAlias("full")
        private String fullName;
        @JsonAlias("short")
        private String shortName;
    }
}
