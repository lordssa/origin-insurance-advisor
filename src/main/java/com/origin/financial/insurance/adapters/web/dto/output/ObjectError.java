package com.origin.financial.insurance.adapters.web.dto.output;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ObjectError {
    private final String message;
    private final String field;
    private final Object parameter;
}
