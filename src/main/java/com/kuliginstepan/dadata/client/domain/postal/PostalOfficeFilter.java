package com.kuliginstepan.dadata.client.domain.postal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Builder;
import lombok.Value;

@Value
@JsonInclude(Include.NON_NULL)
@Builder
public class PostalOfficeFilter {

    private String opstype;
    private String region;
    private String city;

}
