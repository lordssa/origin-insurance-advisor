package com.origin.financial.insurance.application.usecases;

import com.origin.financial.insurance.application.entities.CustomerProfile;
import com.origin.financial.insurance.application.entities.LineInsurance;
import com.origin.financial.insurance.application.entities.MaritalStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class RiskProfileTest {

    @InjectMocks
    RiskProfile riskProfile;

    @Test
    void test_risk_profile_use_case() {
        var customerProfile = CustomerProfile
                .builder()
                .age(60)
                .income(0)
                .baseScore(100)
                .maritalStatus(MaritalStatus.MARRIED)
                .numberDependents(2)
                .build();

        var result = riskProfile.execute(customerProfile);

        Assertions.assertEquals(LineInsurance.values().length, result.size());
    }
}