package com.kuliginstepan.dadata.client.domain.fms;

import com.kuliginstepan.dadata.client.domain.BasicRequest;
import java.util.List;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Singular;
import lombok.Value;

@Value
@EqualsAndHashCode(callSuper = true)
public class FmsUnitRequest extends BasicRequest {

    private List<FmsUnitFilter> filters;

    @Builder
    public FmsUnitRequest(String query, @Singular List<FmsUnitFilter> filters) {
        super(query, null);
        this.filters = filters;
    }
}
