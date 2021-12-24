package com.origin.financial.insurance.adapters.web.dto.input;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonalInformationRequest {
    @NotNull(message = "The field age is required")
    private Integer age;

    @NotNull(message = "The field dependents is required")
    private Integer dependents;

    @NotNull(message = "The income income is required")
    private Integer income;

    @NotNull(message = "The field marital status is required")
    @NotBlank(message = "The field marital status cannot be empty")
    @JsonProperty("marital_status")
    private String maritalStatus;

    @JsonProperty("risk_questions")
    @NotNull(message = "The field risk questions is required")
    @Size(min=3, max=3, message = "The risk question should have three answers")
    private List<Integer> riskQuestions;

    private HouseRequest house;

    private VehicleRequest vehicle;
}
