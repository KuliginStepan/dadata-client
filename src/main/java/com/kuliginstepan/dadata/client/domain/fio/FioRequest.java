package com.kuliginstepan.dadata.client.domain.fio;

import com.kuliginstepan.dadata.client.domain.BasicRequest;
import java.util.Set;
import lombok.Getter;

@Getter
public class FioRequest extends BasicRequest {

    private Set<FioPart> parts;
    private Gender gender;

    public FioRequest(String query, Integer count, Set<FioPart> parts,
        Gender gender) {
        super(query, count);
        this.parts = parts;
        this.gender = gender;
    }
}
