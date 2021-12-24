package com.origin.financial.insurance.application.businessrule;

import com.origin.financial.insurance.application.entities.House;
import com.origin.financial.insurance.application.entities.MaritalStatus;
import com.origin.financial.insurance.application.entities.Vehicle;
import com.origin.financial.insurance.application.exception.IneligiblePlanException;

import java.util.Objects;


public class AutoLineInsuranceRule extends RiskProfileRuleTemplate implements LineInsuranceRule{

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
        if(Objects.isNull(vehicle)) {
            throw new IneligiblePlanException("Customer is ineligible for auto insurance");
        }else if(Objects.nonNull(vehicle.getAge()) && vehicle.getAge() <= 5){
            return 1;
        }

        return 0;
    }
}
