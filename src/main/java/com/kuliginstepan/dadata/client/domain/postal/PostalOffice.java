package com.kuliginstepan.dadata.client.domain.postal;

import com.kuliginstepan.dadata.client.domain.AdditionalProps;
import lombok.EqualsAndHashCode;
import lombok.Value;

/**
 * @see <a href="https://dadata.ru/api/suggest/postal_office/">Postal Office docs</a>
 */

@EqualsAndHashCode(callSuper = true)
@Value
public class PostalOffice extends AdditionalProps {

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
