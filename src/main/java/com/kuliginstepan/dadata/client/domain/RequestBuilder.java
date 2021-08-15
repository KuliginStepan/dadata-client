package com.kuliginstepan.dadata.client.domain;

import com.kuliginstepan.dadata.client.domain.address.FilterProperty;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class RequestBuilder<T> {

    protected final String query;
    protected Integer count;
    protected List<Map<FilterProperty, String>> locationsBoost = new ArrayList<>();

    /**
     * @param kladrId – first 2 digits of region kladr id or full region kladr id
     * @return builder
     */
    public RequestBuilder<T> locationBoost(String kladrId) {
        locationsBoost.add(Collections.singletonMap(FilterProperty.KLADR_ID, kladrId));
        return this;
    }

    /**
     * @param count – default to 10, max 20
     * @return builder
     */
    public RequestBuilder<T> count(int count) {
        this.count = count;
        return this;
    }

    public abstract T build();
}
