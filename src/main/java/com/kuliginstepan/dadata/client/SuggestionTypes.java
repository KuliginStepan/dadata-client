package com.kuliginstepan.dadata.client;

import com.kuliginstepan.dadata.client.domain.SuggestionType;
import com.kuliginstepan.dadata.client.domain.address.Address;
import com.kuliginstepan.dadata.client.domain.address.AddressSuggestion;
import com.kuliginstepan.dadata.client.domain.bank.Bank;
import com.kuliginstepan.dadata.client.domain.bank.BankSuggestion;
import com.kuliginstepan.dadata.client.domain.court.Court;
import com.kuliginstepan.dadata.client.domain.court.CourtSuggestion;
import com.kuliginstepan.dadata.client.domain.delivery.Delivery;
import com.kuliginstepan.dadata.client.domain.delivery.DeliverySuggestion;
import com.kuliginstepan.dadata.client.domain.email.Email;
import com.kuliginstepan.dadata.client.domain.email.EmailSuggestion;
import com.kuliginstepan.dadata.client.domain.fio.Fio;
import com.kuliginstepan.dadata.client.domain.fio.FioSuggestion;
import com.kuliginstepan.dadata.client.domain.fms.FmsUnit;
import com.kuliginstepan.dadata.client.domain.fms.FmsUnitSuggestion;
import com.kuliginstepan.dadata.client.domain.fns.FnsUnit;
import com.kuliginstepan.dadata.client.domain.fns.FnsUnitSuggestion;
import com.kuliginstepan.dadata.client.domain.okpd2.Okpd2;
import com.kuliginstepan.dadata.client.domain.okpd2.Okpd2Suggestion;
import com.kuliginstepan.dadata.client.domain.organization.Organization;
import com.kuliginstepan.dadata.client.domain.organization.OrganizationSuggestion;
import com.kuliginstepan.dadata.client.domain.postal.PostalOffice;
import com.kuliginstepan.dadata.client.domain.postal.PostalOfficeSuggestion;
import lombok.experimental.UtilityClass;

@UtilityClass
public class SuggestionTypes {

    public static final SuggestionType<Organization> ORGANIZATION = new OrganizationSuggestion();
    public static final SuggestionType<Address> ADDRESS = new AddressSuggestion();
    public static final SuggestionType<Bank> BANK = new BankSuggestion();
    public static final SuggestionType<Fio> FIO = new FioSuggestion();
    public static final SuggestionType<Email> EMAIL = new EmailSuggestion();
    public static final SuggestionType<FmsUnit> FMS = new FmsUnitSuggestion();
    public static final SuggestionType<FnsUnit> FNS = new FnsUnitSuggestion();
    public static final SuggestionType<PostalOffice> POSTAL_OFFICE = new PostalOfficeSuggestion();
    public static final SuggestionType<Court> COURT = new CourtSuggestion();
    public static final SuggestionType<Delivery> DELIVERY = new DeliverySuggestion();
    public static final SuggestionType<Okpd2> OKPD_2 = new Okpd2Suggestion();
}
