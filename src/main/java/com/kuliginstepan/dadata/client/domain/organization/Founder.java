package com.kuliginstepan.dadata.client.domain.organization;

import com.kuliginstepan.dadata.client.domain.fio.Fio;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class Founder {

    String ogrn;
    String inn;
    String name;
    Fio fio;
    String hid;
    FounderType type;
    Share share;

    public enum FounderType {

        LEGAL,
        PHYSICAL
    }

    @Value
    @Builder
    @Jacksonized
    public static class Share {

        Share.Type type;
        Double value;
        Double numerator;
        Double denominator;

        public enum Type {

            PERCENT,
            DECIMAL,
            FRACTION
        }
    }
}
