package com.origin.financial.insurance.application.businessrule;

import com.origin.financial.insurance.application.entities.House;
import com.origin.financial.insurance.application.entities.MaritalStatus;
import com.origin.financial.insurance.application.entities.OwnershipStatus;
import com.origin.financial.insurance.application.entities.Vehicle;
import com.origin.financial.insurance.application.exception.IneligiblePlanException;

import java.util.Objects;

public class HomeLineInsuranceRule extends RiskProfileRuleTemplate implements LineInsuranceRule {

    @Override
    int evaluateIncome(int income) {
        if(income > 200){
            return -1;
        }
        return 0;
    }

    @Override
    int evaluateAge(int age) {
        if(age < 30){
            return -2;
        }else if(age >= 30 && age <= 40){
            return -1;
        }
        return 0;
    }

    @Override
    int evaluateOwnershipStatus(House house) {
        if (Objects.isNull(house) || Objects.isNull(house.getOwnershipStatus())) {
            throw new IneligiblePlanException("Customer is ineligible for home insurance");
        }else if(house.getOwnershipStatus().equals(OwnershipStatus.MORTGAGED)){
            return 1;
        }

        return 0;
    }

    @Override
    int evaluateDependents(boolean hasDependents) {
        return 0;
    }

    @Override
    int evaluateMaritalStatus(MaritalStatus maritalStatus) {
        return 0;
    }

    @Override
    int evaluateVehicle(Vehicle vehicle) {
        return 0;
    }
}
