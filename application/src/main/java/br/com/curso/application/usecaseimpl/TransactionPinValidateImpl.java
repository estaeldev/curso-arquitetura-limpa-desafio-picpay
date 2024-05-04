package br.com.curso.application.usecaseimpl;

import br.com.curso.application.gateway.TransactionPinValidateGateway;
import br.com.curso.core.domain.TransactionPin;
import br.com.curso.core.exception.TransferException;
import br.com.curso.core.exception.enums.ErrorCodeEnum;
import br.com.curso.usecase.TransactionPinValidate;

public class TransactionPinValidateImpl implements TransactionPinValidate {

    private final TransactionPinValidateGateway transactionPinValidateGateway;

    public TransactionPinValidateImpl(TransactionPinValidateGateway transactionPinValidateGateway) {
        this.transactionPinValidateGateway = transactionPinValidateGateway;
    }

    @Override
    public void validate(TransactionPin transactionPin) throws TransferException {

        Boolean isTransactionPinValidate = this.transactionPinValidateGateway.validate(transactionPin);

        if(Boolean.FALSE.equals(isTransactionPinValidate)) {
            throw new TransferException(ErrorCodeEnum.PIN0001.getMessage(), ErrorCodeEnum.PIN0001.getCode());
        }

    }
    

}
