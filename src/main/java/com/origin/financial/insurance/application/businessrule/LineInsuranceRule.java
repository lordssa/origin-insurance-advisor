package com.origin.financial.insurance.application.businessrule;

import com.origin.financial.insurance.application.entities.CustomerProfile;
import com.origin.financial.insurance.application.entities.Plan;

public interface LineInsuranceRule {
    Plan getPlan(CustomerProfile customerProfile);
}
