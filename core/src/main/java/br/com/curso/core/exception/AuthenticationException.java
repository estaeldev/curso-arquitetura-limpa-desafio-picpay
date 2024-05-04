package br.com.curso.core.exception;

public class AuthenticationException extends Exception {

    private final String code;

    public AuthenticationException(String message, String code) {
        super(message);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    
}
