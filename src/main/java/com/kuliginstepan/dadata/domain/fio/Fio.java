package com.kuliginstepan.dadata.domain.fio;

import lombok.Data;

@Data
public class Fio {

    private String name;
    private String surname;
    private String patronymic;
    private String gender;
    private String source;
    private String qc;
}
