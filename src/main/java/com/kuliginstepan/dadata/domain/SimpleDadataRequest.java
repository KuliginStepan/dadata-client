package com.kuliginstepan.dadata.domain;

public class SimpleDadataRequest extends DadataRequest{

    public SimpleDadataRequest(String query) {
        super(query, null);
    }

    public SimpleDadataRequest(String query, Integer count) {
        super(query, count);
    }
}
