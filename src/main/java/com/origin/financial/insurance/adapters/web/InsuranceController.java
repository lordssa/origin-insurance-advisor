package com.origin.financial.insurance.adapters.web;

import com.origin.financial.insurance.adapters.web.dto.input.PersonalInformationRequest;
import com.origin.financial.insurance.adapters.web.dto.output.AdvisorResult;
import com.origin.financial.insurance.adapters.web.mapper.AdvisorResultMapper;
import com.origin.financial.insurance.adapters.web.mapper.PersonalInformationMapper;
import com.origin.financial.insurance.application.entities.LineInsurance;
import com.origin.financial.insurance.application.ports.in.RiskProfileUseCase;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

import static java.util.Optional.ofNullable;

@Slf4j
@Validated
@RestController
@AllArgsConstructor
@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
public class InsuranceController {

    private final RiskProfileUseCase riskProfileUseCase;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public AdvisorResult getRiskProfile(@RequestBody @Valid PersonalInformationRequest personalInformation) {

        return ofNullable(personalInformation)
                .map(PersonalInformationMapper::toEntity)
                .map(riskProfileUseCase::execute)
                .map(AdvisorResultMapper::fromUsecase)
                .orElse(AdvisorResult.builder().build());
    }
}