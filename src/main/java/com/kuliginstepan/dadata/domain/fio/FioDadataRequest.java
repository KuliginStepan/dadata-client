package com.kuliginstepan.dadata.domain.fio;

import com.kuliginstepan.dadata.domain.DadataRequest;
import java.util.Set;
import lombok.Getter;

@Getter
public class FioDadataRequest extends DadataRequest {

    private Set<FioPart> parts;
    private Gender gender;

    public FioDadataRequest(String query, Integer count, Set<FioPart> parts,
        Gender gender) {
        super(query, count);
        this.parts = parts;
        this.gender = gender;
    }
}
