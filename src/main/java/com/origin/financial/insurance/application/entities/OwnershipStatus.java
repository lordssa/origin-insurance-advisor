package com.origin.financial.insurance.application.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum OwnershipStatus {
    OWNED("owned"),
    MORTGAGED("mortgaged"),
    NA(null);

    private String description;

    public static OwnershipStatus getByDescription(String description){
        return Arrays.stream(OwnershipStatus.values())
                .filter(ownershipStatus -> description.equals(ownershipStatus.getDescription()))
                .findFirst()
                .orElse(OwnershipStatus.NA);
    }
}
