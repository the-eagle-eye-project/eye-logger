package com.theeagleeyeproject.eyelogger.exception;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ExceptionResponse {

    private String transactionId;

    /**
     * Http error code that it's been derived from the HttpStatus that is inside the ErrorCategory ENUM.
     */
    private int errorCode;

    /**
     * ENUM that contains all the runtime error categories and will contain standardized information about the exception.
     */
    private ExceptionCategory exceptionCategory;

    /**
     * Standardize message contained in the ErrorCategory ENUM, to return a standard message to the consumer.
     */
    private String errorMessage;

    /**
     * Custom message created by the developer to describe a specific Exception.
     */
    private String developerMessage;

    /**
     * Constructor with private access to prevent the object to be instantiated without the proper parameters.
     */
    private ExceptionResponse() {
    }

    /**
     * Constructor used to create the ResponseEntity schema to return the error to the consumer.
     *
     * @param errorCode         http status code derived from the HttpStatus ENUM, contained in the ErrorCategory ENUM.
     * @param exceptionCategory String value of the ErrorCategory ENUM
     * @param errorMessage      standardized message contained in the ErrorCategory ENUM.
     * @param developerMessage  custom message created by the developer to describe a specific exception.
     */
    public ExceptionResponse(final int errorCode, final ExceptionCategory exceptionCategory, final String errorMessage, final String developerMessage) {
        this.errorCode = errorCode;
        this.exceptionCategory = exceptionCategory;
        this.errorMessage = errorMessage;
        this.developerMessage = developerMessage;
    }
}
