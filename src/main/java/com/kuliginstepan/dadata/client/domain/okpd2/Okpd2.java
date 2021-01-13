package com.kuliginstepan.dadata.client.domain.okpd2;

import com.kuliginstepan.dadata.client.domain.AdditionalProps;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;

/**
 * @see <a href="https://dadata.ru/api/suggest/okpd2/">OKPD 2 docs</a>
 */
@Value
@Builder
@EqualsAndHashCode(callSuper = true)
public class Okpd2 extends AdditionalProps {

    String idx;
    String razdel;
    String kod;
    String name;
}
