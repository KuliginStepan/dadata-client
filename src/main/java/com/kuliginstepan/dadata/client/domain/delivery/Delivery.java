package com.kuliginstepan.dadata.client.domain.delivery;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.kuliginstepan.dadata.client.domain.AdditionalProps;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;

/**
 * @see <a href="https://dadata.ru/api/delivery/">Delivery docs</a>
 */

@Value
@Builder
@EqualsAndHashCode(callSuper = true)
public class Delivery extends AdditionalProps {

    @JsonAlias("kladr_id")
    String kladrId;
    @JsonAlias("fias_id")
    String fiasId;
    @JsonAlias("boxberry_id")
    String boxberryId;
    @JsonAlias("cdek_id")
    String cdekId;
    @JsonAlias("dpd_id")
    String dpdId;
}
