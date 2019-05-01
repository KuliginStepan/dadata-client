package com.kuliginstepan.dadata.client.exception;

import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@Getter
@ToString
public class DadataException extends RuntimeException {

    private final HttpStatus status;
    private final ErrorDetails details;

    public DadataException(HttpStatus status, ErrorDetails details) {
        this.status = status;
        this.details = details;
    }
}
