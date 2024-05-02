package br.com.curso.core.exception.enums;

public enum ErrorCodeEnum {

    ON0001("Tax Number Inválido", "ON-0001"),
    TR0001("Transfer Inválido, Usuário Lojista não pode transferir", "TR-0001"),
    TR0002("Transfer Inválido, Saldo Indisponível", "TR-0002"),
    TRP0001("Pin Inválido", "TRP-0001");
    
    private final String message;
    private final String code;

    ErrorCodeEnum(String message, String code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public String getCode() {
        return code;
    }

}
