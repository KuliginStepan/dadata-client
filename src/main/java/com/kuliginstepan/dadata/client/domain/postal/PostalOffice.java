package com.kuliginstepan.dadata.client.domain.postal;

import com.kuliginstepan.dadata.client.domain.AdditionalProps;
import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * @see <a href="https://dadata.ru/api/suggest/postal_office/">Postal Office docs</a>
 */

@Value
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@Jacksonized
public class PostalOffice extends AdditionalProps {

    String index;
    String opsname;
    String opstype;
    String opssuubm;
    String region;
    String area;
    String city;
    String settlement;
    String actdate;
}
