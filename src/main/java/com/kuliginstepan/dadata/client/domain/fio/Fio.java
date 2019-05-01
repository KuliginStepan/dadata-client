package com.kuliginstepan.dadata.client.domain.fio;

import lombok.Data;

/**
 * @see <a href="https://confluence.hflabs.ru/pages/viewpage.action?pageId=204669113">Dadata fio object</a>
 */

@Data
public class Fio {

    private String name;
    private String surname;
    private String patronymic;
    private Gender gender;
    private String source;
    private String qc;
}
