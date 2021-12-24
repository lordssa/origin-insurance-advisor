package com.origin.financial.insurance.application.businessrule;

import com.origin.financial.insurance.application.entities.CustomerProfile;
import com.origin.financial.insurance.application.entities.MaritalStatus;
import com.origin.financial.insurance.application.entities.Plan;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class LifeLineInsuranceRuleTest {

    @InjectMocks
    LifeLineInsuranceRule lifeLineInsuranceRule;

    @Test
    void test_customer_elderly_is_ineligible_for_life_insurance() {
        var customerProfile = CustomerProfile
                .builder()
                .age(61)
                .income(100)
                .baseScore(100)
                .maritalStatus(MaritalStatus.SINGLE)
                .vehicle(null)
                .house(null)
                .numberDependents(2)
                .build();

        var plan = lifeLineInsuranceRule.getPlan(customerProfile);

        Assertions.assertEquals(Plan.INELIGIBLE, plan);
    }

    @Test
    void test_customer_is_eligible_for_responsible_plan() {
        var customerProfile = CustomerProfile
                .builder()
                .age(60)
                .income(100)
                .baseScore(2)
                .maritalStatus(MaritalStatus.SINGLE)
                .numberDependents(2)
                .build();

        var plan = lifeLineInsuranceRule.getPlan(customerProfile);

        Assertions.assertEquals(Plan.RESPONSIBLE, plan);
    }

    @Test
    void test_single_customer_with_dependents_is_eligible_for_regular_plan() {
        var customerProfile = CustomerProfile
                .builder()
                .age(60)
                .income(100)
                .baseScore(0)
                .maritalStatus(MaritalStatus.SINGLE)
                .numberDependents(2)
                .build();

        var plan = lifeLineInsuranceRule.getPlan(customerProfile);

        Assertions.assertEquals(Plan.REGULAR, plan);
    }

    @Test
    void test_single_customer_with_no_dependents_is_eligible_for_economic_plan() {
        var customerProfile = CustomerProfile
                .builder()
                .age(60)
                .income(100)
                .baseScore(0)
                .maritalStatus(MaritalStatus.SINGLE)
                .numberDependents(0)
                .build();

        var plan = lifeLineInsuranceRule.getPlan(customerProfile);

        Assertions.assertEquals(Plan.ECONOMIC, plan);
    }
}