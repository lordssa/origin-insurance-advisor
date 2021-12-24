package com.origin.financial.insurance.adapters.web.dto.output;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseError {
    private final String message;
    private final int code;
    private final String status;
    //private final String objectName;
    private final List<ObjectError> errors;
}
