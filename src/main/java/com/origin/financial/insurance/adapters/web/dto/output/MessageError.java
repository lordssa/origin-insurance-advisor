package com.origin.financial.insurance.adapters.web.dto.output;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class MessageError {
    private String code;
    private String message;
}
