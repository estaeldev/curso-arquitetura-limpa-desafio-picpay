package br.com.curso.application.usecaseimpl;

import java.math.BigDecimal;

import br.com.curso.application.gateway.TransferGateway;
import br.com.curso.core.domain.Transaction;
import br.com.curso.core.domain.Wallet;
import br.com.curso.core.exception.InternalServerErrorException;
import br.com.curso.core.exception.NotFoundException;
import br.com.curso.core.exception.NotificationException;
import br.com.curso.core.exception.PinException;
import br.com.curso.core.exception.TransferException;
import br.com.curso.core.exception.enums.ErrorCodeEnum;
import br.com.curso.usecase.CreateTransaction;
import br.com.curso.usecase.FindWalletByTaxNumber;
import br.com.curso.usecase.TransactionPinValidate;
import br.com.curso.usecase.TransactionValidate;
import br.com.curso.usecase.TransferUse;
import br.com.curso.usecase.UserNotification;

public class TransferUseImpl implements TransferUse {

    private final FindWalletByTaxNumber findWalletByTaxNumber;
    private final TransactionValidate transactionValidate;
    private final CreateTransaction createTransaction;
    private final TransferGateway transferGateway;
    private final UserNotification userNotification;
    private final TransactionPinValidate transactionPinValidate;

    public TransferUseImpl(FindWalletByTaxNumber findWalletByTaxNumber, TransactionValidate transactionValidate,
            CreateTransaction createTransaction, TransferGateway transferGateway, UserNotification userNotification, 
            TransactionPinValidate transactionPinValidate) {
        this.findWalletByTaxNumber = findWalletByTaxNumber;
        this.transactionValidate = transactionValidate;
        this.createTransaction = createTransaction;
        this.transferGateway = transferGateway;
        this.userNotification = userNotification;
        this.transactionPinValidate = transactionPinValidate;
    }


    @Override
    public Boolean transfer(String fromTaxNumber, String toTaxNumber, BigDecimal value, String pin) 
        throws InternalServerErrorException, TransferException, NotFoundException, NotificationException, PinException {

        Wallet fromWallet = this.findWalletByTaxNumber.findWalletByTaxNumber(fromTaxNumber);
        Wallet toWallet = this.findWalletByTaxNumber.findWalletByTaxNumber(toTaxNumber);

        if(Boolean.TRUE.equals(fromWallet.getTransactionPin().getBlocked())) {
            throw new PinException(ErrorCodeEnum.PIN0002.getMessage(), ErrorCodeEnum.PIN0002.getCode());
        }
        
        this.transactionPinValidate.validate(fromWallet.getTransactionPin());
        
        fromWallet.transfer(value);
        toWallet.receiveValue(value);

        Transaction transaction = this.createTransaction.create(new Transaction(fromWallet, toWallet, value));

        this.transactionValidate.validate(transaction);

        Boolean isTransfer = this.transferGateway.transfer(transaction);

        if(Boolean.FALSE.equals(isTransfer)) {
            throw new InternalServerErrorException(ErrorCodeEnum.TR0003.getMessage(), ErrorCodeEnum.TR0003.getCode());
        }

        Boolean isNotificate = this.userNotification.notificate(transaction, toWallet.getUser().getEmail());

        if(Boolean.FALSE.equals(isNotificate)) {
            throw new NotificationException(ErrorCodeEnum.NO0001.getMessage(), ErrorCodeEnum.NO0001.getCode());
        }

        return Boolean.TRUE;
    }
    
}