package br.com.curso.application.usecaseimpl;

import br.com.curso.application.gateway.TransactionPinValidateGateway;
import br.com.curso.core.domain.TransactionPin;
import br.com.curso.core.exception.PinException;
import br.com.curso.core.exception.enums.ErrorCodeEnum;
import br.com.curso.usecase.TransactionPinValidate;
import br.com.curso.usecase.UpdateTransactionPin;

public class TransactionPinValidateImpl implements TransactionPinValidate {

    private final TransactionPinValidateGateway transactionPinValidateGateway;
    private final UpdateTransactionPin updateTransactionPin;

    public TransactionPinValidateImpl(TransactionPinValidateGateway transactionPinValidateGateway, 
        UpdateTransactionPin updateTransactionPin) {
        this.transactionPinValidateGateway = transactionPinValidateGateway;
        this.updateTransactionPin = updateTransactionPin;
    }

    @Override
    public void validate(TransactionPin transactionPin) throws PinException {

        if(Boolean.TRUE.equals(transactionPin.getBlocked())) {
            throw new PinException(ErrorCodeEnum.PIN0002.getMessage(), ErrorCodeEnum.PIN0002.getCode());
        }

        Boolean isTransactionPinValidate = this.transactionPinValidateGateway.validate(transactionPin);

        if(Boolean.FALSE.equals(isTransactionPinValidate)) {
            transactionPin.setAttempt();
            TransactionPin transactionPinUpdate = this.updateTransactionPin.update(transactionPin);
            throw new PinException(ErrorCodeEnum.pin0001GetMessage(transactionPinUpdate.getAttempt()), 
                ErrorCodeEnum.PIN0001.getCode());
        }
        
        if(transactionPin.getAttempt() < 3) {
            transactionPin.restaureAttempt();
            this.updateTransactionPin.update(transactionPin);
        }

    }

}
