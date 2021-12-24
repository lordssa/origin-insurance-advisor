package com.origin.financial.insurance.application.entities;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerProfile {
    private int income;
    private int age;
    private int numberDependents;
    private Vehicle vehicle;
    private House house;
    private MaritalStatus maritalStatus;
    private int baseScore;

    public boolean hasDependents(){
        return numberDependents > 0;
    }
}
