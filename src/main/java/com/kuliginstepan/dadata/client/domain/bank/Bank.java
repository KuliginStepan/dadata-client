package com.kuliginstepan.dadata.client.domain.bank;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.kuliginstepan.dadata.client.domain.AdditionalProps;
import com.kuliginstepan.dadata.client.domain.Suggestion;
import com.kuliginstepan.dadata.client.domain.address.Address;
import com.kuliginstepan.dadata.client.domain.organization.State;
import java.util.List;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * @see <a href="https://confluence.hflabs.ru/pages/viewpage.action?pageId=262996082">Dadata bank object</a>
 */

@Value
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@Jacksonized
public class Bank extends AdditionalProps {

    String bic;
    String swift;
    String inn;
    String kpp;
    @JsonAlias("registration_number")
    String registrationNumber;
    @JsonAlias("correspondent_account")
    String correspondentAccount;
    @JsonAlias("treasury_accounts")
    List<String> treasuryAccounts;
    Name name;
    @JsonAlias("payment_city")
    String paymentCity;
    Opf opf;
    Cbr cbr;
    Suggestion<Address> address;
    State state;

    @Value
    @Builder
    @Jacksonized
    public static class Opf {

        BankType type;
        @JsonAlias("full")
        String fullName;
        @JsonAlias("short")
        String shortName;
    }

    @Value
    @Builder
    @Jacksonized
    public static class Cbr {

        Name name;
        String bic;
        Suggestion<Address> address;
    }

    @Value
    @Builder
    @Jacksonized
    public static class Name {

        String payment;
        @JsonAlias("full")
        String fullName;
        @JsonAlias("short")
        String shortName;
    }
}
