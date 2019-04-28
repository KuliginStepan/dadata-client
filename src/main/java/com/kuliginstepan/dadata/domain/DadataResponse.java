package com.kuliginstepan.dadata.domain;

import com.fasterxml.jackson.annotation.JsonAlias;
import java.util.List;
import lombok.Data;

@Data
public class DadataResponse<T> {

    private List<Suggestion<T>> suggestions;

    @Data
    public static class Suggestion<T> {

        private String value;
        @JsonAlias("unrestricted_value")
        private String unrestrictedValue;
        private T data;
    }
}
