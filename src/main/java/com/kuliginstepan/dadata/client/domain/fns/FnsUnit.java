package com.kuliginstepan.dadata.client.domain.fns;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Value;

/**
 * @see <a href="https://dadata.ru/api/suggest/fns_unit/">FNS Unit docs</a>
 */

@Value
public class FnsUnit {

    private String code;
    private String name;
    @JsonAlias("name_short")
    private String shortName;
    private String address;
    private String phone;
    private String comment;
    @JsonAlias("payment_name")
    private String paymentName;
    private String oktmo;
    private String inn;
    private String kpp;
    @JsonAlias("bank_name")
    private String bankName;
    @JsonAlias("bank_bic")
    private String bankBic;
    @JsonAlias("bank_account")
    private String bankAccount;
    @JsonAlias("parent_code")
    private String parentCode;
    @JsonAlias("parent_name")
    private String parentName;
    @JsonAlias("parent_address")
    private String parentAddress;
    @JsonAlias("parent_phone")
    private String parentPhone;
    @JsonAlias("parent_comment")
    private String parentComment;

}
