package br.com.curso.usecase;

import br.com.curso.core.domain.TransactionPin;
import br.com.curso.core.exception.PinException;

public interface TransactionPinValidate {
    
    void validate(TransactionPin transactionPin) throws PinException;

}
