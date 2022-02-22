package com.kuliginstepan.dadata.client.domain.fns;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.kuliginstepan.dadata.client.domain.AdditionalProps;
import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * @see <a href="https://dadata.ru/api/suggest/fns_unit/">FNS Unit docs</a>
 */

@Value
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@Jacksonized
public class FnsUnit extends AdditionalProps {

    String code;
    String name;
    @JsonAlias("name_short")
    String shortName;
    String address;
    String phone;
    String comment;
    @JsonAlias("payment_name")
    String paymentName;
    String oktmo;
    String inn;
    String kpp;
    @JsonAlias("bank_name")
    String bankName;
    @JsonAlias("bank_bic")
    String bankBic;
    @JsonAlias("bank_account")
    String bankAccount;
    @JsonAlias("parent_code")
    String parentCode;
    @JsonAlias("parent_name")
    String parentName;
    @JsonAlias("parent_address")
    String parentAddress;
    @JsonAlias("parent_phone")
    String parentPhone;
    @JsonAlias("parent_comment")
    String parentComment;

}
