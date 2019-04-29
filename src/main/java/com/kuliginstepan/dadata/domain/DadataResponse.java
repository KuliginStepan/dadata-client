package com.kuliginstepan.dadata.domain;

import java.util.List;
import lombok.Data;

@Data
public class DadataResponse<T> {

    private List<Suggestion<T>> suggestions;

}
