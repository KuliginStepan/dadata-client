package com.kuliginstepan.dadata.domain.fio;

import com.kuliginstepan.dadata.domain.DadataRequest;
import lombok.Getter;

@Getter
public class FioDadataRequest extends DadataRequest {

    private FioPart[] parts;

    public FioDadataRequest(String query, FioPart... parts) {
        super(query);
        this.parts = parts;
    }
}
