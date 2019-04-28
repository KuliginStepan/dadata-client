package com.kuliginstepan.dadata.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DadataRequest {

    private String query;
    private int count = 1;

    public DadataRequest(String query) {
        this.query = query;
    }
}
