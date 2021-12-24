package com.origin.financial.insurance.application.businessrule;

import com.origin.financial.insurance.application.entities.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class DisabilityLineInsuranceRuleTest {

    @InjectMocks
    DisabilityLineInsuranceRule disabilityLineInsuranceRule;

    @Test
    void test_customer_without_income_is_ineligible_for_disability_insurance() {
        var customerProfile = CustomerProfile
                .builder()
                .age(60)
                .income(0)
                .baseScore(100)
                .maritalStatus(MaritalStatus.MARRIED)
                .numberDependents(2)
                .build();

        var plan = disabilityLineInsuranceRule.getPlan(customerProfile);

        Assertions.assertEquals(Plan.INELIGIBLE, plan);
    }

    @Test
    void test_customer_elderly_is_ineligible_for_disability_insurance() {
        var customerProfile = CustomerProfile
                .builder()
                .age(61)
                .income(100)
                .baseScore(2)
                .maritalStatus(MaritalStatus.SINGLE)
                .numberDependents(2)
                .build();

        var plan = disabilityLineInsuranceRule.getPlan(customerProfile);

        Assertions.assertEquals(Plan.INELIGIBLE, plan);
    }

    @Test
    void test_customer_with_house_mortgaged_and_dependents_is_eligible_for_responsible_plan() {
        var house = House
                .builder()
                .ownershipStatus(OwnershipStatus.MORTGAGED)
                .build();

        var customerProfile = CustomerProfile
                .builder()
                .age(51)
                .income(200)
                .baseScore(1)
                .maritalStatus(MaritalStatus.SINGLE)
                .numberDependents(2)
                .house(house)
                .vehicle(Vehicle.builder().age(3).build())
                .build();

        var plan = disabilityLineInsuranceRule.getPlan(customerProfile);

        Assertions.assertEquals(Plan.RESPONSIBLE, plan);
    }

    @Test
    void test_young_customer_with_house_mortgaged_and_dependents_is_eligible_for_regular_plan() {
        var house = House
                .builder()
                .ownershipStatus(OwnershipStatus.MORTGAGED)
                .build();

        var customerProfile = CustomerProfile
                .builder()
                .age(25)
                .income(200)
                .baseScore(1)
                .maritalStatus(MaritalStatus.SINGLE)
                .numberDependents(2)
                .house(house)
                .vehicle(Vehicle.builder().age(3).build())
                .build();

        var plan = disabilityLineInsuranceRule.getPlan(customerProfile);

        Assertions.assertEquals(Plan.REGULAR, plan);
    }

    @Test
    void test_young_customer_married_with_house_mortgaged_and_dependents_is_eligible_for_economic_plan() {
        var house = House
                .builder()
                .ownershipStatus(OwnershipStatus.MORTGAGED)
                .build();

        var customerProfile = CustomerProfile
                .builder()
                .age(25)
                .income(200)
                .baseScore(1)
                .maritalStatus(MaritalStatus.MARRIED)
                .numberDependents(2)
                .house(house)
                .vehicle(Vehicle.builder().age(3).build())
                .build();

        var plan = disabilityLineInsuranceRule.getPlan(customerProfile);

        Assertions.assertEquals(Plan.ECONOMIC, plan);
    }
}