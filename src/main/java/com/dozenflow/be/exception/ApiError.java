package com.dozenflow.be.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

public class ApiError {

    private int status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;
    private String message;

    @JsonInclude(JsonInclude.Include.NON_EMPTY) // Only include this field in JSON if it's not null or empty
    private List<String> subErrors;

    private ApiError() {
        timestamp = LocalDateTime.now();
    }

    public ApiError(HttpStatus httpStatus, String message, List<String> subErrors) {
        this();
        this.status = httpStatus.value();
        this.message = message;
        this.subErrors = subErrors;
    }

    // Getters and Setters
    public int getStatus() { return status; }
    public LocalDateTime getTimestamp() { return timestamp; }
    public String getMessage() { return message; }
    public List<String> getSubErrors() { return subErrors; }
}