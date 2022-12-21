package com.dg.heptensecretsanta.web.validation.exception.error;

import org.springframework.http.HttpStatus;

public class ApiErrorDto {
    private final HttpStatus status;
    private final String message;
    private final String errorInfo;
    private final ValidationErrorDto validationError;

    public ApiErrorDto(HttpStatus status, String message) {
        this(status, message, null, null);
    }

    public ApiErrorDto(HttpStatus status, String message, ValidationErrorDto validationError) {
        this(status, message, null, validationError);
    }

    public ApiErrorDto(HttpStatus status, String message, String error) {
        this(status, message, error, null);
    }

    public ApiErrorDto(HttpStatus status, String message, String errorInfo, ValidationErrorDto validationError) {
        super();
        this.status = status;
        this.message = message;
        this.errorInfo = errorInfo;
        this.validationError = validationError;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public String getErrorInfo() {
        return errorInfo;
    }

    public ValidationErrorDto getValidationError() {
        return validationError;
    }

}
