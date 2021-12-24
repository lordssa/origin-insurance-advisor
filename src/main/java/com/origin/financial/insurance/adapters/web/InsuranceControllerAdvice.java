package com.origin.financial.insurance.adapters.web;

import com.origin.financial.insurance.adapters.web.dto.output.MessageError;
import com.origin.financial.insurance.adapters.web.dto.output.ObjectError;
import com.origin.financial.insurance.adapters.web.dto.output.ResponseError;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class InsuranceControllerAdvice extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<ObjectError> errors = getErrors(ex);
        ResponseError errorResponse = getErrorResponse(ex, status, errors);
        return new ResponseEntity<>(errorResponse, status);
    }

    private ResponseError getErrorResponse(MethodArgumentNotValidException ex, HttpStatus status, List<ObjectError> errors) {
        return new ResponseError("There are invalid fields in the request", status.value(),
                status.getReasonPhrase(), errors);
    }

    private List<ObjectError> getErrors(MethodArgumentNotValidException ex) {
        return ex.getBindingResult().getFieldErrors().stream()
                .map(error -> new ObjectError(error.getDefaultMessage(), error.getField(), error.getRejectedValue()))
                .collect(Collectors.toList());
    }

    @ResponseBody
    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    MessageError handleException(Exception exception){
        return MessageError
                .builder()
                .code(String.valueOf(HttpStatus.BAD_REQUEST.value()))
                .message(exception.getMessage())
                .build();
    }
}
