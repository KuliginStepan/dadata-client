package com.kuliginstepan.dadata.client.domain;

import java.util.List;
import lombok.Value;

@Value
public class DadataResponse<T> {

    List<Suggestion<T>> suggestions;

}
