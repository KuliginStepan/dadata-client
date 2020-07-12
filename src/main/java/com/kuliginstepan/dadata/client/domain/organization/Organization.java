package com.kuliginstepan.dadata.client.domain.organization;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.kuliginstepan.dadata.client.domain.AdditionalProps;
import com.kuliginstepan.dadata.client.domain.OrganizationStatus;
import com.kuliginstepan.dadata.client.domain.Suggestion;
import com.kuliginstepan.dadata.client.domain.address.Address;
import com.kuliginstepan.dadata.client.json.LocalDateDeserializer;
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

    String kpp;
    Double capital;
    Management management;
    List<String> founders;
    List<String> managers;
    OrganizationType type;
    @JsonAlias("branch_type")
    BranchType branchType;
    @JsonAlias("branch_count")
    Integer branchCount;
    @JsonAlias("employee_count")
    Integer employeeCount;
    String source;
    String qc;
    String hid;
    State state;
    Opf opf;
    Name name;
    String inn;
    String ogrn;
    String okpo;
    String okved;
    List<Okved> okveds;
    String authorities;
    String documents;
    List<String> licenses;
    Suggestion<Address> address;
    List<String> phones;
    List<String> emails;
    @JsonAlias("ogrn_date")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    LocalDate ogrnDate;
    @JsonAlias("okved_type")
    String okvedType;

    @Value
    @Builder
    public static class Management {

        String name;
        String post;
    }

    @Value
    @Builder
    public static class State {

        OrganizationStatus status;
        @JsonAlias("actuality_date")
        @JsonDeserialize(using = LocalDateDeserializer.class)
        LocalDate actualityDate;
        @JsonAlias("registration_date")
        @JsonDeserialize(using = LocalDateDeserializer.class)
        LocalDate registrationDate;
        @JsonAlias("liquidation_date")
        @JsonDeserialize(using = LocalDateDeserializer.class)
        LocalDate liquidationDate;
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
        @JsonAlias("full")
        String fullName;
        @JsonAlias("short")
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
