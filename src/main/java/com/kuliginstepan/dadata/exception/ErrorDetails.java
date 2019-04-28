package com.kuliginstepan.dadata.exception;

import lombok.Data;

@Data
public class ErrorDetails {

    private String family;
    private String reason;
    private String message;
}
