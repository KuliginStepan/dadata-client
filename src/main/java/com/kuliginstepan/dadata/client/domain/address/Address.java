package com.kuliginstepan.dadata.client.domain.address;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.kuliginstepan.dadata.client.domain.AdditionalProps;
import java.time.ZoneId;
import java.util.List;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * @see <a href="https://confluence.hflabs.ru/pages/viewpage.action?pageId=204669103">Dadata address object</a>
 */

@Value
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@Jacksonized
public class Address extends AdditionalProps {

    @JsonAlias("postal_code")
    String postalCode;
    String country;
    @JsonAlias("country_iso_code")
    String countryIsoCode;
    @JsonAlias("federal_district")
    String federalDistrict;
    @JsonAlias("region_fias_id")
    String regionFiasId;
    @JsonAlias("region_kladr_id")
    String regionKladrId;
    @JsonAlias("region_iso_code")
    String regionIsoCode;
    @JsonAlias("region_with_type")
    String regionWithType;
    @JsonAlias("region_type")
    String regionType;
    @JsonAlias("region_type_full")
    String regionTypeFull;
    String region;
    @JsonAlias("area_fias_id")
    String areaFiasId;
    @JsonAlias("area_kladr_id")
    String areaKladrId;
    @JsonAlias("area_with_type")
    String areaWithType;
    @JsonAlias("area_type")
    String areaType;
    @JsonAlias("area_type_full")
    String areaTypeFull;
    String area;
    @JsonAlias("city_fias_id")
    String cityFiasId;
    @JsonAlias("city_kladr_id")
    String cityKladrId;
    @JsonAlias("city_with_type")
    String cityWithType;
    @JsonAlias("city_type")
    String cityType;
    @JsonAlias("city_type_full")
    String cityTypeFull;
    String city;
    @JsonAlias("city_area")
    String cityArea;
    @JsonAlias("city_district_fias_id")
    String cityDistrictFiasId;
    @JsonAlias("city_district_kladr_id")
    String cityDistrictKladrId;
    @JsonAlias("city_district_with_type")
    String cityDistrictWithType;
    @JsonAlias("city_district_type")
    String cityDistrictType;
    @JsonAlias("city_district_type_full")
    String cityDistrictTypeFull;
    @JsonAlias("city_district")
    String cityDistrict;
    @JsonAlias("settlement_fias_id")
    String settlementFiasId;
    @JsonAlias("settlement_kladr_id")
    String settlementKladrId;
    @JsonAlias("settlement_with_type")
    String settlementWithType;
    @JsonAlias("settlement_type")
    String settlementType;
    @JsonAlias("settlement_type_full")
    String settlementTypeFull;
    String settlement;
    @JsonAlias("street_fias_id")
    String streetFiasId;
    @JsonAlias("street_kladr_id")
    String streetKladrId;
    @JsonAlias("street_with_type")
    String streetWithType;
    @JsonAlias("street_type")
    String streetType;
    @JsonAlias("street_type_full")
    String streetTypeFull;
    String street;
    @JsonAlias("house_fias_id")
    String houseFiasId;
    @JsonAlias("house_kladr_id")
    String houseKladrId;
    @JsonAlias("house_type")
    String houseType;
    @JsonAlias("house_type_full")
    String houseTypeFull;
    String house;
    @JsonAlias("block_type")
    String blockType;
    @JsonAlias("block_type_full")
    String blockTypeFull;
    String block;
    @JsonAlias("flat_type")
    String flatType;
    @JsonAlias("flat_type_full")
    String flatTypeFull;
    String flat;
    @JsonAlias("flat_area")
    Double flatArea;
    @JsonAlias("square_meter_price")
    Double squareMeterPrice;
    @JsonAlias("flat_price")
    Double flatPrice;
    @JsonAlias("postal_box")
    String postalBox;
    @JsonAlias("fias_id")
    String fiasId;
    @JsonAlias("fias_code")
    String fiasCode;
    @JsonAlias("fias_level")
    String fiasLevel;
    @JsonAlias("fias_actuality_state")
    String fiasActualityState;
    @JsonAlias("kladr_id")
    String kladrId;
    @JsonAlias("geoname_id")
    String geonameId;
    @JsonAlias("capital_marker")
    String capitalMarker;
    String okato;
    String oktmo;
    @JsonAlias("tax_office")
    String taxOffice;
    @JsonAlias("tax_office_legal")
    String taxOfficeLegal;
    ZoneId timezone;
    @JsonAlias("geo_lat")
    Double geoLat;
    @JsonAlias("geo_lon")
    Double geoLon;
    @JsonAlias("beltway_hit")
    String beltwayHit;
    @JsonAlias("beltway_distance")
    Double beltwayDistance;
    List<Metro> metro;
    @JsonAlias("qc_geo")
    String qcGeo;
    @JsonAlias("qc_complete")
    String qcComplete;
    @JsonAlias("qc_house")
    String qcHouse;
    @JsonAlias("history_values")
    List<String> historyValues;
    @JsonAlias("unparsed_parts")
    String unparsedParts;
    String source;
    String qc;

    @Value
    @Builder
    @Jacksonized
    public static class Metro {

        String name;
        String line;
        Double distance;
    }
}
