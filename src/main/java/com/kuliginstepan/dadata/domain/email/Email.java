package com.kuliginstepan.dadata.domain.email;

import lombok.Data;

@Data
public class Email {

    private String local;
    private String domain;
    private String source;
    private String qc;
}
