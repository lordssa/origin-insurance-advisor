package com.origin.financial.insurance.adapters.web.dto.output;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AdvisorResult {
    private String auto;
    private String disability;
    private String home;
    private String life;
}
