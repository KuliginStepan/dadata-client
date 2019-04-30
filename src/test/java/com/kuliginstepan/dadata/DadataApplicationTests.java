package com.kuliginstepan.dadata;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.kuliginstepan.dadata.domain.Suggestion;
import com.kuliginstepan.dadata.domain.address.AddressDadataRequestBuilder;
import com.kuliginstepan.dadata.domain.bank.BankDadataRequestBuilder;
import com.kuliginstepan.dadata.domain.fio.FioPart;
import com.kuliginstepan.dadata.domain.organization.BranchType;
import com.kuliginstepan.dadata.domain.organization.Organization;
import com.kuliginstepan.dadata.domain.organization.OrganizationDadataRequestBuilder;
import com.kuliginstepan.dadata.domain.organization.OrganizationType;
import java.io.IOException;
import org.junit.Test;

public class DadataApplicationTests {

    DadataClient client = new DadataClient("d0a06c568347cb09905d9a0fe9009380eb6b25d3");

    @Test
    public void name() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        client.suggestAddress(
            AddressDadataRequestBuilder.create("юбилейная").location("city", "Кострома").restrictValue().build()).toStream()
            .forEach(it -> {
                try {
                    System.out.println(mapper.writeValueAsString(it));
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
            });
    }

    @Test
    public void name5() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        client.suggestOrganization(OrganizationDadataRequestBuilder.create("сбербанк").location("44").branchType(
            BranchType.BRANCH).organizationType(OrganizationType.LEGAL).build()).toStream()
            .forEach(it -> {
                    System.out.println(it);
            });
    }

    @Test
    public void name6() throws IOException {
        Suggestion<Organization> organization = client.findOrganizationById("7707083893").block();
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        System.out.println(organization);
    }

    @Test
    public void name7() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        client.suggestBank(BankDadataRequestBuilder.create("сбербанк").location("44").build()).toStream()
            .forEach(it -> {
                    System.out.println(it);
            });
    }

    @Test
    public void name8() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        client.suggestFio("Викто", FioPart.NAME, FioPart.PATRONYMIC).toStream()
            .forEach(it -> {
                try {
                    System.out.println(mapper.writeValueAsString(it));
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
            });
    }

    @Test
    public void name9() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        client.suggestEmail("stepan@mail").toStream()
            .forEach(it -> {
                try {
                    System.out.println(mapper.writeValueAsString(it));
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
            });
    }
//
//    @Test(expected = DadataException.class)
//    public void name2() {
//        DadataClient client = new DadataClient("123456");
//        client.findAddress("москва хабар").block();
//    }
//
//    @Test(expected = ReadTimeoutException.class)
//    public void name4() {
//        DadataClient client = new DadataClient("123456", Duration.of(1, ChronoUnit.MILLIS));
//        client.findAddress("москва хабар").block();
//    }
}
