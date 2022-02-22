package com.kuliginstepan.dadata.client.domain.okpd2;

import com.kuliginstepan.dadata.client.domain.AdditionalProps;
import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * @see <a href="https://dadata.ru/api/suggest/okpd2/">OKPD 2 docs</a>
 */
@Value
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@Jacksonized
public class Okpd2 extends AdditionalProps {

    String idx;
    String razdel;
    String kod;
    String name;
}
