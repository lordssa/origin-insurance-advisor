package com.origin.financial.insurance.application.businessrule;

import com.origin.financial.insurance.application.entities.*;
import com.origin.financial.insurance.application.exception.IneligiblePlanException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
abstract class RiskProfileRuleTemplate {
    protected RiskProfileRuleTemplate() {
    }

    public Plan getPlan(CustomerProfile customerProfile) {
        try {
            final var riskScore = customerProfile.getBaseScore() +
                    evaluateIncome(customerProfile.getIncome()) +
                    evaluateAge(customerProfile.getAge()) +
                    evaluateOwnershipStatus(customerProfile.getHouse()) +
                    evaluateDependents(customerProfile.hasDependents()) +
                    evaluateMaritalStatus(customerProfile.getMaritalStatus()) +
                    evaluateVehicle(customerProfile.getVehicle());

            if (riskScore <= 0) {
                return Plan.ECONOMIC;
            } else if (riskScore > 0 && riskScore <= 2) {
                return Plan.REGULAR;
            } else {
                return Plan.RESPONSIBLE;
            }
        }catch (IneligiblePlanException ineligiblePlanException){
            log.info(ineligiblePlanException.getMessage());
            return Plan.INELIGIBLE;
        }
    }

    abstract int evaluateIncome(int income);

    abstract int evaluateAge(int age);

    abstract int evaluateOwnershipStatus(House house);

    abstract int evaluateDependents(boolean hasDependents);

    abstract int evaluateMaritalStatus(MaritalStatus maritalStatus);

    abstract int evaluateVehicle(Vehicle vehicle);
}
