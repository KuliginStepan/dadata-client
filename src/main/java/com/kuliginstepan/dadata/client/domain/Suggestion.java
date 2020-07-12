package com.kuliginstepan.dadata.client.domain;


import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Suggestion<T> {

    String value;
    @JsonAlias("unrestricted_value")
    String unrestrictedValue;
    T data;
}
