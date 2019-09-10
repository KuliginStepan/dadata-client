package com.kuliginstepan.dadata.client.domain.fio;

import com.kuliginstepan.dadata.client.domain.AdditionalProps;
import lombok.EqualsAndHashCode;
import lombok.Value;

/**
 * @see <a href="https://confluence.hflabs.ru/pages/viewpage.action?pageId=204669113">Dadata fio object</a>
 */

@EqualsAndHashCode(callSuper = true)
@Value
public class Fio extends AdditionalProps {

    private String name;
    private String surname;
    private String patronymic;
    private Gender gender;
    private String source;
    private String qc;
}
