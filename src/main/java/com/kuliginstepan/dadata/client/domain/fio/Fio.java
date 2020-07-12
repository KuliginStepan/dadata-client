package com.kuliginstepan.dadata.client.domain.fio;

import com.kuliginstepan.dadata.client.domain.AdditionalProps;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;

/**
 * @see <a href="https://confluence.hflabs.ru/pages/viewpage.action?pageId=204669113">Dadata fio object</a>
 */

@Value
@Builder
@EqualsAndHashCode(callSuper = true)
public class Fio extends AdditionalProps {

    String name;
    String surname;
    String patronymic;
    Gender gender;
    String source;
    String qc;
}
