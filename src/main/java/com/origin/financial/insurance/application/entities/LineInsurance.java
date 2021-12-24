package com.origin.financial.insurance.application.entities;

import com.origin.financial.insurance.application.businessrule.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum LineInsurance {
    AUTO("auto", new AutoLineInsuranceRule()),
    DISABILITY("disability", new DisabilityLineInsuranceRule()),
    HOME("home", new HomeLineInsuranceRule()),
    LIFE("life", new LifeLineInsuranceRule());

    private String description;
    private LineInsuranceRule lineInsuranceRule;
}
