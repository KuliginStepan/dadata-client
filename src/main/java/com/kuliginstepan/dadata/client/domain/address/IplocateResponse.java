package com.kuliginstepan.dadata.client.domain.address;

import com.kuliginstepan.dadata.client.domain.Suggestion;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class IplocateResponse {

    Suggestion<Address> location;
}
