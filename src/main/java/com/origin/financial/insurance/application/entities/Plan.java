package com.origin.financial.insurance.application.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Plan {
    REGULAR("regular"),
    RESPONSIBLE("responsible"),
    ECONOMIC("economic"),
    INELIGIBLE("ineligible"),
    NA(null);

    private String description;
}
