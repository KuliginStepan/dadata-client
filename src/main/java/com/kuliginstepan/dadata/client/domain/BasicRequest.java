package com.kuliginstepan.dadata.client.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.ToString;

@JsonInclude(Include.NON_EMPTY)
@ToString
public class BasicRequest {

    private String query;
    private Integer count;

    public BasicRequest(String query) {
        this.query = query;
    }

    public BasicRequest(String query, Integer count) {
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
