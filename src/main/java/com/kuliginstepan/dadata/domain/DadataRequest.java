package com.kuliginstepan.dadata.domain;

public abstract class DadataRequest {

    private String query;

    protected DadataRequest(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }

    public int getCount() {
        return 10;
    }
}
