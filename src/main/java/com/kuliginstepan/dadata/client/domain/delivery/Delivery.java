package com.kuliginstepan.dadata.client.domain.delivery;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.kuliginstepan.dadata.client.domain.AdditionalProps;
import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * @see <a href="https://dadata.ru/api/delivery/">Delivery docs</a>
 */

@Value
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@Jacksonized
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
