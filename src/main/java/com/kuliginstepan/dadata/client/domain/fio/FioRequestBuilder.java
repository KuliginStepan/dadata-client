package com.kuliginstepan.dadata.client.domain.fio;


import com.kuliginstepan.dadata.client.domain.RequestBuilder;
import java.util.EnumSet;
import java.util.Set;

public class FioRequestBuilder extends RequestBuilder<FioRequest> {

    private Set<FioPart> parts = EnumSet.allOf(FioPart.class);
    private Gender gender;

    public static FioRequestBuilder create(String query) {
        return new FioRequestBuilder(query);
    }

    protected FioRequestBuilder(String query) {
        super(query);
    }

    public FioRequestBuilder part(FioPart part) {
        parts.add(part);
        return this;
    }

    public FioRequestBuilder gender(Gender gender) {
        this.gender = gender;
        return this;
    }

    @Override
    public RequestBuilder<FioRequest> locationBoost(String kladrId) {
        throw new UnsupportedOperationException("option 'locationsBoost' unable for fio request");
    }

    @Override
    public FioRequest build() {
        return new FioRequest(super.query, super.count, parts, gender);
    }
}
