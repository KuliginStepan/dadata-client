package com.kuliginstepan.dadata.client.domain;


import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class Suggestion<T> {

    String value;
    @JsonAlias("unrestricted_value")
    String unrestrictedValue;
    T data;
}
