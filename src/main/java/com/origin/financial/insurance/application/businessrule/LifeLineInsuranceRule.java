package com.origin.financial.insurance.application.businessrule;

import com.origin.financial.insurance.application.entities.House;
import com.origin.financial.insurance.application.entities.MaritalStatus;
import com.origin.financial.insurance.application.entities.Vehicle;
import com.origin.financial.insurance.application.exception.IneligiblePlanException;

public class LifeLineInsuranceRule extends RiskProfileRuleTemplate implements LineInsuranceRule {

    @Override
    int evaluateIncome(int income) {
        if(income > 200){
            return -1;
        }
        return 0;
    }

    @Override
    int evaluateAge(int age) {
        if (age > 60) {
            throw new IneligiblePlanException("Customer is ineligible for life insurance");
        }else if(age < 30){
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
        if(hasDependents){
            return 1;
        }

        return 0;
    }

    @Override
    int evaluateMaritalStatus(MaritalStatus maritalStatus) {
        if(maritalStatus.equals(MaritalStatus.MARRIED)){
            return 1;
        }
        return 0;
    }

    @Override
    int evaluateVehicle(Vehicle vehicle) {
        return 0;
    }
}
