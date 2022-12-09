package com.kuliginstepan.dadata.client.exception;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class ErrorDetails {

    String family;
    String reason;
    String message;
}
