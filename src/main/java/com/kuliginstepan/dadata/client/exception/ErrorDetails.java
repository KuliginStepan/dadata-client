package com.kuliginstepan.dadata.client.exception;

import lombok.Value;

@Value
public class ErrorDetails {

    private String family;
    private String reason;
    private String message;
}
