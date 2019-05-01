package com.kuliginstepan.dadata.client.domain.email;

import lombok.Data;

/**
 * @see <a href="https://confluence.hflabs.ru/pages/viewpage.action?pageId=234782809">Dadata email object</a>
 */

@Data
public class Email {

    private String local;
    private String domain;
    private String source;
    private String qc;
}
