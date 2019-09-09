package com.kuliginstepan.dadata.client.domain.address;

import com.fasterxml.jackson.annotation.JsonAlias;
import java.time.ZoneId;
import java.util.List;
import lombok.Data;

/**
 * @see <a href="https://confluence.hflabs.ru/pages/viewpage.action?pageId=204669103">Dadata address object</a>
 */

@Data
public class Address {

    @JsonAlias("postal_code")
    private String postalCode;
    private String country;
    @JsonAlias("country_iso_code")
    private String countryIsoCode;
    @JsonAlias("federal_district")
    private String federalDistrict;
    @JsonAlias("region_fias_id")
    private String regionFiasId;
    @JsonAlias("region_kladr_id")
    private String regionKladrId;
    @JsonAlias("region_iso_code")
    private String regionIsoCode;
    @JsonAlias("region_with_type")
    private String regionWithType;
    @JsonAlias("region_type")
    private String regionType;
    @JsonAlias("region_type_full")
    private String regionTypeFull;
    private String region;
    @JsonAlias("area_fias_id")
    private String areaFiasId;
    @JsonAlias("area_kladr_id")
    private String areaKladrId;
    @JsonAlias("area_with_type")
    private String areaWithType;
    @JsonAlias("area_type")
    private String areaType;
    @JsonAlias("area_type_full")
    private String areaTypeFull;
    private String area;
    @JsonAlias("city_fias_id")
    private String cityFiasId;
    @JsonAlias("city_kladr_id")
    private String cityKladrId;
    @JsonAlias("city_with_type")
    private String cityWithType;
    @JsonAlias("city_type")
    private String cityType;
    @JsonAlias("city_type_full")
    private String cityTypeFull;
    private String city;
    @JsonAlias("city_area")
    private String cityArea;
    @JsonAlias("city_district_fias_id")
    private String cityDistrictFiasId;
    @JsonAlias("city_district_kladr_id")
    private String cityDistrictKladrId;
    @JsonAlias("city_district_with_type")
    private String cityDistrictWithType;
    @JsonAlias("city_district_type")
    private String cityDistrictType;
    @JsonAlias("city_district_type_full")
    private String cityDistrictTypeFull;
    @JsonAlias("city_district")
    private String cityDistrict;
    @JsonAlias("settlement_fias_id")
    private String settlementFiasId;
    @JsonAlias("settlement_kladr_id")
    private String settlementKladrId;
    @JsonAlias("settlement_with_type")
    private String settlementWithType;
    @JsonAlias("settlement_type")
    private String settlementType;
    @JsonAlias("settlement_type_full")
    private String settlementTypeFull;
    private String settlement;
    @JsonAlias("street_fias_id")
    private String streetFiasId;
    @JsonAlias("street_kladr_id")
    private String streetKladrId;
    @JsonAlias("street_with_type")
    private String streetWithType;
    @JsonAlias("street_type")
    private String streetType;
    @JsonAlias("street_type_full")
    private String streetTypeFull;
    private String street;
    @JsonAlias("house_fias_id")
    private String houseFiasId;
    @JsonAlias("house_kladr_id")
    private String houseKladrId;
    @JsonAlias("house_type")
    private String houseType;
    @JsonAlias("house_type_full")
    private String houseTypeFull;
    private String house;
    @JsonAlias("block_type")
    private String blockType;
    @JsonAlias("block_type_full")
    private String blockTypeFull;
    private String block;
    @JsonAlias("flat_type")
    private String flatType;
    @JsonAlias("flat_type_full")
    private String flatTypeFull;
    private String flat;
    @JsonAlias("flat_area")
    private Double flatArea;
    @JsonAlias("square_meter_price")
    private Double squareMeterPrice;
    @JsonAlias("flat_price")
    private Double flatPrice;
    @JsonAlias("postal_box")
    private String postalBox;
    @JsonAlias("fias_id")
    private String fiasId;
    @JsonAlias("fias_code")
    private String fiasCode;
    @JsonAlias("fias_level")
    private String fiasLevel;
    @JsonAlias("fias_actuality_state")
    private String fiasActualityState;
    @JsonAlias("kladr_id")
    private String kladrId;
    @JsonAlias("geoname_id")
    private String geonameId;
    @JsonAlias("capital_marker")
    private String capitalMarker;
    private String okato;
    private String oktmo;
    @JsonAlias("tax_office")
    private String taxOffice;
    @JsonAlias("tax_office_legal")
    private String taxOfficeLegal;
    private ZoneId timezone;
    @JsonAlias("geo_lat")
    private Double geoLat;
    @JsonAlias("geo_lon")
    private Double geoLon;
    @JsonAlias("beltway_hit")
    private String beltwayHit;
    @JsonAlias("beltway_distance")
    private Double beltwayDistance;
    private List<Metro> metro;
    @JsonAlias("qc_geo")
    private String qcGeo;
    @JsonAlias("qc_complete")
    private String qcComplete;
    @JsonAlias("qc_house")
    private String qcHouse;
    @JsonAlias("history_values")
    private List<String> historyValues;
    @JsonAlias("unparsed_parts")
    private String unparsedParts;
    private String source;
    private String qc;

    @Data
    public static class Metro {

        private String name;
        private String line;
        private Double distance;
    }
}
