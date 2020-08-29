package com.kuliginstepan.dadata.client.domain.fio;

import com.kuliginstepan.dadata.client.domain.BasicRequest;
import java.util.Set;
import lombok.EqualsAndHashCode;
import lombok.Value;

/**
 * @see <a href="https://confluence.hflabs.ru/pages/viewpage.action?pageId=204669115">Dadata fio suggestion docs</a>
 * @see com.kuliginstepan.dadata.client.domain.fio.FioRequestBuilder
 */

@Value
@EqualsAndHashCode(callSuper = true)
public class FioRequest extends BasicRequest {

    Set<FioPart> parts;
    Gender gender;

    public FioRequest(String query, Integer count, Set<FioPart> parts,
        Gender gender) {
        super(query, count);
        this.parts = parts;
        this.gender = gender;
    }
}
