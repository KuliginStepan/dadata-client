package com.kuliginstepan.dadata.client.domain.email;

import com.kuliginstepan.dadata.client.domain.AdditionalProps;
import lombok.EqualsAndHashCode;
import lombok.Value;

/**
 * @see <a href="https://confluence.hflabs.ru/pages/viewpage.action?pageId=234782809">Dadata email object</a>
 */

@EqualsAndHashCode(callSuper = true)
@Value
public class Email extends AdditionalProps {

    private String local;
    private String domain;
    private String source;
    private String qc;
}
