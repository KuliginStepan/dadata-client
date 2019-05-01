package com.kuliginstepan.dadata.client.domain.bank;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.kuliginstepan.dadata.client.domain.Suggestion;
import com.kuliginstepan.dadata.client.domain.organization.Organization.State;
import com.kuliginstepan.dadata.client.domain.address.Address;
import java.util.List;
import lombok.Data;

/**
 * @see <a href="https://confluence.hflabs.ru/pages/viewpage.action?pageId=262996082">Dadata bank object</a>
 */

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

        private BankType type;
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
