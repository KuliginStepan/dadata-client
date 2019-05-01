package com.kuliginstepan.dadata.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class DadataRequestBuilder<T> {

    protected final String query;
    protected Integer count;
    protected List<Map<String, String>> locationsBoost = new ArrayList<>();

    public DadataRequestBuilder<T> locationBoost(String kladrId) {
        locationsBoost.add(Collections.singletonMap("kladr_id", kladrId));
        return this;
    }

    public DadataRequestBuilder<T> count(int count) {
        this.count = count;
        return this;
    }

    public abstract T build();
}
