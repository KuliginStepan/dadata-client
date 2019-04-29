package com.kuliginstepan.dadata.domain;


import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

@Data
public class Suggestion<T> {

    private String value;
    @JsonAlias("unrestricted_value")
    private String unrestrictedValue;
    private T data;
}
