package com.kuliginstepan.dadata.domain.fio;


import com.kuliginstepan.dadata.domain.DadataRequestBuilder;
import java.util.HashSet;
import java.util.Set;

public class FioDadataRequestBuilder extends DadataRequestBuilder<FioDadataRequest> {

    private Set<FioPart> parts = new HashSet<>();
    private Gender gender;

    public static FioDadataRequestBuilder create(String query) {
        return new FioDadataRequestBuilder(query);
    }

    protected FioDadataRequestBuilder(String query) {
        super(query);
    }

    public FioDadataRequestBuilder part(FioPart part) {
        parts.add(part);
        return this;
    }

    public FioDadataRequestBuilder gender(Gender gender) {
        this.gender = gender;
        return this;
    }

    @Override
    public DadataRequestBuilder<FioDadataRequest> locationBoost(String kladrId) {
        throw new UnsupportedOperationException("option 'locationsBoost' unable for fio request");
    }

    @Override
    public FioDadataRequest build() {
        return new FioDadataRequest(super.query, super.count, parts, gender);
    }
}
