package com.kuliginstepan.dadata.client.domain.email;

import com.kuliginstepan.dadata.client.domain.AdditionalProps;
import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * @see <a href="https://confluence.hflabs.ru/pages/viewpage.action?pageId=234782809">Dadata email object</a>
 */

@Value
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@Jacksonized
public class Email extends AdditionalProps {

    String local;
    String domain;
    String source;
    String qc;
}
