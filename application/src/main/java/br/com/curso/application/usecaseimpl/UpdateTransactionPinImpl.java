package br.com.curso.application.usecaseimpl;

import br.com.curso.application.gateway.UpdateTransactionPinGateway;
import br.com.curso.core.domain.TransactionPin;
import br.com.curso.usecase.UpdateTransactionPin;

public class UpdateTransactionPinImpl implements UpdateTransactionPin {

    private final UpdateTransactionPinGateway updateTransactionPinGateway;

    public UpdateTransactionPinImpl(UpdateTransactionPinGateway updateTransactionPinGateway) {
        this.updateTransactionPinGateway = updateTransactionPinGateway;
    }

    @Override
    public TransactionPin update(TransactionPin transactionPin) {
        
        return this.updateTransactionPinGateway.update(transactionPin);

    }
    
}
