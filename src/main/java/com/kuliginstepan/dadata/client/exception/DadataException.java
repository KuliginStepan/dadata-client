package com.kuliginstepan.dadata.client.exception;

import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatusCode;

@Getter
@ToString
public class DadataException extends RuntimeException {

    private final HttpStatusCode status;
    private final ErrorDetails details;

    public DadataException(HttpStatusCode status, ErrorDetails details) {
        this.status = status;
        this.details = details;
    }
}
