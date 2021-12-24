package com.origin.financial.insurance.application.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum MaritalStatus {
    SINGLE("single"),
    MARRIED("married"),
    NA(null);

    private String description;

    public static MaritalStatus getByDescription(String description){
        return Arrays.stream(MaritalStatus.values())
                .filter(maritalStatus -> description.equals(maritalStatus.getDescription()))
                .findFirst()
                .orElse(MaritalStatus.NA);
    }
}
