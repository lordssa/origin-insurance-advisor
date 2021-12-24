package com.origin.financial.insurance.adapters.web.dto.input;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class HouseRequest {
    @JsonProperty("ownership_status")
    private String ownershipStatus;
}
