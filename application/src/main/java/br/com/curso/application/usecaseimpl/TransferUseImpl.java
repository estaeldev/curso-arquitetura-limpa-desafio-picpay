package br.com.curso.application.usecaseimpl;

import java.math.BigDecimal;

import br.com.curso.core.domain.Transaction;
import br.com.curso.core.domain.Wallet;
import br.com.curso.usecase.CreateTransaction;
import br.com.curso.usecase.FindWalletByTaxNumber;
import br.com.curso.usecase.TransactionValidate;
import br.com.curso.usecase.TransferUse;

public class TransferUseImpl implements TransferUse {

    private FindWalletByTaxNumber findWalletByTaxNumber;
    private TransactionValidate transactionValidate;
    private CreateTransaction createTransaction;

    public TransferUseImpl(FindWalletByTaxNumber findWalletByTaxNumber, TransactionValidate transactionValidate) {
        this.findWalletByTaxNumber = findWalletByTaxNumber;
        this.transactionValidate = transactionValidate;
    }

    @Override
    public Boolean transfer(String fromTaxNumber, String toTaxNumber, BigDecimal value) {

        Wallet fromWallet = this.findWalletByTaxNumber.findByTaxNumber(fromTaxNumber);
        Wallet toWallet = this.findWalletByTaxNumber.findByTaxNumber(toTaxNumber);

        Transaction transaction = this.createTransaction.create(new Transaction(fromWallet, toWallet, value));

        this.transactionValidate.validate(transaction);

        

        throw new UnsupportedOperationException("Unimplemented method 'transfer'");
    }
    
}
