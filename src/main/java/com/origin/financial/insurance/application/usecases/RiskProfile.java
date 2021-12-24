package com.origin.financial.insurance.application.usecases;

import com.origin.financial.insurance.application.entities.CustomerProfile;
import com.origin.financial.insurance.application.entities.LineInsurance;
import com.origin.financial.insurance.application.entities.Plan;
import com.origin.financial.insurance.application.ports.in.RiskProfileUseCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;


@Slf4j
@Component
public class RiskProfile implements RiskProfileUseCase {

    @Override
    public Map<String, Plan> execute(CustomerProfile customerProfile) {

        return Arrays.stream(LineInsurance.values())
                .collect(Collectors.toMap(
                        key -> key.getDescription(),
                        value -> value.getLineInsuranceRule().getPlan(customerProfile))
                );
    }
}
