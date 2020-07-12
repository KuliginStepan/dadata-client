package com.kuliginstepan.dadata.client.domain.email;

import com.kuliginstepan.dadata.client.domain.AdditionalProps;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;

/**
 * @see <a href="https://confluence.hflabs.ru/pages/viewpage.action?pageId=234782809">Dadata email object</a>
 */

@Value
@Builder
@EqualsAndHashCode(callSuper = true)
public class Email extends AdditionalProps {

    String local;
    String domain;
    String source;
    String qc;
}
