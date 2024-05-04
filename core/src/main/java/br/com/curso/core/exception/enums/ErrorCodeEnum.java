package br.com.curso.core.exception.enums;

public enum ErrorCodeEnum {

    // Erro OnBold
    ON0001("Tax Number Inválido", "ON-0001"),
    ON0002("Tax Number Indisponível", "ON-0002"),
    ON0003("Email Indisponível", "ON-0003"),
    ON0004("Houve um erro na criação do usuário", "ON-0004"),

    // Error Transaction
    TR0001("Transfer Inválido, Usuário Lojista não pode transferir", "TR-0001"),
    TR0002("Transfer Inválido, Saldo Indisponível", "TR-0002"),
    TR0003("Transfer Inválido, houve um erro ao realizar a transferência", "TR-0003"),
    TR0004("Transfer Inválido, transferência não autorizada", "TR-0004"),
    
    // Error TransactionPin
    PIN0001("Pin Inválido, você ainda tem %d tentativa(s) restante(s)", "PIN-0001"),
    PIN0002("Pin de transação bloqueado", "PIN-0002"),

    // Error Wallet
    WA0001("Carteira não encontrada", "WA-0001"),

    // Error Notification
    NO0001("Houve um erro na notificação do usuário", "NO-0001"),

    // Error Authentication
    ATH0001("Houve um erro na autenticação do usuário", "ATH-0001");
    
    
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

    public static String pin0001GetMessage(Integer attempt) {
        return String.format(PIN0001.message, attempt);
    }

}
