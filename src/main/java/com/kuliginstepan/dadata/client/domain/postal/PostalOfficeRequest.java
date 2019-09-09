package com.kuliginstepan.dadata.client.domain.postal;

import com.kuliginstepan.dadata.client.domain.BasicRequest;
import java.util.List;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Singular;
import lombok.Value;

@Value
@EqualsAndHashCode(callSuper = true)
public class PostalOfficeRequest extends BasicRequest {

    private List<PostalOfficeFilter> filters;

    @Builder
    public PostalOfficeRequest(String query, @Singular List<PostalOfficeFilter> filters) {
        super(query, null);
        this.filters = filters;
    }
}
