package com.kuliginstepan.dadata.domain;

public abstract class DadataRequest {

    private String query;
    private Integer count;

    protected DadataRequest(String query, Integer count) {
        this.query = query;
        this.count = count;
    }

    public String getQuery() {
        return query;
    }

    public int getCount(){
        return count == null ? 10 : count;
    };
}
