package com.origin.financial.insurance.application.businessrule;

import com.origin.financial.insurance.application.entities.CustomerProfile;
import com.origin.financial.insurance.application.entities.MaritalStatus;
import com.origin.financial.insurance.application.entities.Plan;
import com.origin.financial.insurance.application.entities.Vehicle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AutoLineInsuranceRuleTest {

    @InjectMocks
    AutoLineInsuranceRule autoLineInsuranceRule;

    @Test
    void test_customer_without_car_is_ineligible_for_auto_insurance() {
        var customerProfile = CustomerProfile
                .builder()
                .age(60)
                .income(100)
                .baseScore(100)
                .maritalStatus(MaritalStatus.MARRIED)
                .vehicle(null)
                .numberDependents(2)
                .build();

        var plan = autoLineInsuranceRule.getPlan(customerProfile);

        Assertions.assertEquals(Plan.INELIGIBLE, plan);
    }

    @Test
    void test_customer_with_used_car_is_eligible_for_responsible_plan() {
        var customerProfile = CustomerProfile
                .builder()
                .age(50)
                .income(200)
                .baseScore(2)
                .maritalStatus(MaritalStatus.SINGLE)
                .numberDependents(2)
                .vehicle(Vehicle.builder().age(3).build())
                .build();

        var plan = autoLineInsuranceRule.getPlan(customerProfile);

        Assertions.assertEquals(Plan.RESPONSIBLE, plan);
    }

    @Test
    void test_young_customer_with_used_car_is_eligible_for_regular_plan() {
        var customerProfile = CustomerProfile
                .builder()
                .age(20)
                .income(100)
                .baseScore(2)
                .maritalStatus(MaritalStatus.SINGLE)
                .numberDependents(2)
                .vehicle(Vehicle.builder().age(3).build())
                .build();

        var plan = autoLineInsuranceRule.getPlan(customerProfile);

        Assertions.assertEquals(Plan.REGULAR, plan);
    }

    @Test
    void test_young_customer_with_used_car_is_eligible_for_economic_plan() {
        var customerProfile = CustomerProfile
                .builder()
                .age(35)
                .income(220)
                .baseScore(1)
                .maritalStatus(MaritalStatus.MARRIED)
                .numberDependents(2)
                .vehicle(Vehicle.builder().age(3).build())
                .build();

        var plan = autoLineInsuranceRule.getPlan(customerProfile);

        Assertions.assertEquals(Plan.ECONOMIC, plan);
    }
}