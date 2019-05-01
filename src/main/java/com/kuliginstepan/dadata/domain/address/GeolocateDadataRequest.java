package com.kuliginstepan.dadata.domain.address;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kuliginstepan.dadata.domain.DadataRequest;
import lombok.Getter;

@Getter
public class GeolocateDadataRequest extends DadataRequest {

    private double lat;
    private double lon;
    @JsonProperty("radius_meters")
    private int radius = 100;

    public GeolocateDadataRequest(double lat, double lon) {
        super(null, null);
        this.lat = lat;
        this.lon = lon;
    }

    public GeolocateDadataRequest(double lat, double lon, int radius) {
        super(null, null);
        this.lat = lat;
        this.lon = lon;
        this.radius = radius;
    }
}
