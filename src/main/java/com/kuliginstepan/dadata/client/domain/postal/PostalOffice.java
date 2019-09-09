package com.kuliginstepan.dadata.client.domain.postal;

import lombok.Value;

/**
 * @see <a href="https://dadata.ru/api/suggest/postal_office/">Postal Office docs</a>
 */

@Value
public class PostalOffice {

    private String index;
    private String opsname;
    private String opstype;
    private String opssuubm;
    private String region;
    private String area;
    private String city;
    private String settlement;
    private String actdate;
}
