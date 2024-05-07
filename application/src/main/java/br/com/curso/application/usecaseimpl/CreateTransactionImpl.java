package br.com.curso.application.usecaseimpl;

import java.math.BigDecimal;
import java.util.Objects;

import br.com.curso.application.gateway.CreateTransactionGateway;
import br.com.curso.core.domain.Transaction;
import br.com.curso.core.domain.Wallet;
import br.com.curso.core.exception.TransferException;
import br.com.curso.core.exception.enums.ErrorCodeEnum;
import br.com.curso.usecase.CreateTransaction;

public class CreateTransactionImpl implements CreateTransaction {

    private final CreateTransactionGateway createTransactionGateway;

    public CreateTransactionImpl(CreateTransactionGateway createTransactionGateway) {
        this.createTransactionGateway = createTransactionGateway;
    }

    @Override
    public Transaction create(Wallet fromWallet, Wallet toWallet, BigDecimal value) throws TransferException {

        Transaction transaction = new Transaction(fromWallet, toWallet, value);

        Transaction transactionSaved = this.createTransactionGateway.create(transaction);

        if(Objects.isNull(transactionSaved)) {
            throw new TransferException(ErrorCodeEnum.TR0003.getMessage(), ErrorCodeEnum.TR0003.getCode());
        }
        
        return transactionSaved;

    }
    
}
