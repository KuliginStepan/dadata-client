package com.kuliginstepan.dadata.client.domain.postal;

import lombok.Value;

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
