package br.com.pagseguro.servicelayer.model;

import br.com.pagseguro.servicelayer.exception.ErrorType;
import lombok.Getter;

public class DefaultException extends RuntimeException{
    @Getter
    private final ErrorType errorType;

    DefaultException(String message, Throwable cause) {
        super(message, cause);
        this.errorType = ErrorType.INTERNAL_ERROR;
    }

    DefaultException(ErrorType errorType) {
        this.errorType = errorType;
    }

    public String getResponseMessage(){
        return this.errorType.getResponseMessage();
    }

    public String getResponseTitle(){
        return this.errorType.getResponseTitle();
    }

    public String getErrorCode(){
        return this.errorType.getErrorCode();
    }
    public int getStatusCode(){
        return this.errorType.getStatusCode();
    }
}
