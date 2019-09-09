package com.kuliginstepan.dadata.client.domain.court;

import com.kuliginstepan.dadata.client.domain.BasicRequest;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Singular;
import lombok.Value;

@Value
@EqualsAndHashCode(callSuper = true)
public class CourtRequest extends BasicRequest {

    private List<Map<String, String>> filters;

    @Builder
    public CourtRequest(String query, @Singular List<String> regionCodes) {
        super(query, null);
        filters = regionCodes.stream()
            .map(code -> Collections.singletonMap("region_code", code))
            .collect(Collectors.toList());
    }
}
