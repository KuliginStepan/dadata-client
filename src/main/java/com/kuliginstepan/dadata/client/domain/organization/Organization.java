package com.kuliginstepan.dadata.client.domain.organization;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.kuliginstepan.dadata.client.domain.AdditionalProps;
import com.kuliginstepan.dadata.client.domain.Suggestion;
import com.kuliginstepan.dadata.client.domain.address.Address;
import com.kuliginstepan.dadata.client.domain.email.Email;
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
    List<Suggestion<Email>> emails;


}
