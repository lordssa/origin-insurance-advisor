package com.origin.financial.insurance.application.ports.in;

import com.origin.financial.insurance.application.entities.CustomerProfile;
import com.origin.financial.insurance.application.entities.Plan;

import java.util.Map;

public interface RiskProfileUseCase {
        Map<String, Plan> execute(CustomerProfile customerProfile);
}
