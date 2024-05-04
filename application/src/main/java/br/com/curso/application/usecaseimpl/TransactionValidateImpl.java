package br.com.curso.application.usecaseimpl;

import br.com.curso.application.gateway.TransactionValidateGateway;
import br.com.curso.core.domain.Transaction;
import br.com.curso.core.exception.TransferException;
import br.com.curso.core.exception.enums.ErrorCodeEnum;
import br.com.curso.usecase.TransactionValidate;

public class TransactionValidateImpl implements TransactionValidate {

    private final TransactionValidateGateway transactionValidateGateway;

    public TransactionValidateImpl(TransactionValidateGateway transactionValidateGateway) {
        this.transactionValidateGateway = transactionValidateGateway;
    }

    @Override
    public void validate(Transaction transaction) throws TransferException {

        Boolean isTransactionValidate = this.transactionValidateGateway.validate(transaction);

        if(Boolean.FALSE.equals(isTransactionValidate)) {
            throw new TransferException(ErrorCodeEnum.TR0001.getMessage(), ErrorCodeEnum.TR0001.getCode());
        }

    }
    
}
