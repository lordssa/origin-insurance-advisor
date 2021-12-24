package com.origin.financial.insurance.adapters.web.mapper;

import com.origin.financial.insurance.adapters.web.dto.output.AdvisorResult;
import com.origin.financial.insurance.application.entities.LineInsurance;
import com.origin.financial.insurance.application.entities.Plan;

import java.util.Map;

public class AdvisorResultMapper {

    public static AdvisorResult fromUsecase(Map<String, Plan> riskProfile){
        var advisor = AdvisorResult
                .builder()
                .auto(getPlanFromRiskProfile(riskProfile, LineInsurance.AUTO))
                .disability(getPlanFromRiskProfile(riskProfile, LineInsurance.DISABILITY))
                .home(getPlanFromRiskProfile(riskProfile, LineInsurance.HOME))
                .life(getPlanFromRiskProfile(riskProfile, LineInsurance.LIFE))
                .build();

        return advisor;
    }

    private static String getPlanFromRiskProfile(Map<String, Plan> riskProfile, LineInsurance lineInsurance) {
        return riskProfile
                .getOrDefault(lineInsurance.getDescription(), Plan.NA)
                .getDescription();
    }
}
