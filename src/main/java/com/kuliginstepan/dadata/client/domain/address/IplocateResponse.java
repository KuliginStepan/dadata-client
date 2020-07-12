package com.kuliginstepan.dadata.client.domain.address;

import com.kuliginstepan.dadata.client.domain.Suggestion;
import lombok.Builder;
import lombok.Value;
import org.springframework.lang.Nullable;

@Value
@Builder
public class IplocateResponse {

    @Nullable
    Suggestion<Address> location;
}
