package com.kuliginstepan.dadata.client.domain;

import java.util.List;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class DadataResponse<T> {

    List<Suggestion<T>> suggestions;

}
