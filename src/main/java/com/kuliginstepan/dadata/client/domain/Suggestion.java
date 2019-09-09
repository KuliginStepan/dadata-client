package com.kuliginstepan.dadata.client.domain;


import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Value;

@Value
public class Suggestion<T> {

    private String value;
    @JsonAlias("unrestricted_value")
    private String unrestrictedValue;
    private T data;
}
