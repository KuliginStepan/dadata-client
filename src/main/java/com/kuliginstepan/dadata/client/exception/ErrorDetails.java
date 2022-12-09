package com.kuliginstepan.dadata.client.exception;

import lombok.Value;

@Value
public class ErrorDetails {

    String family;
    String reason;
    String message;
}
