package br.com.curso.application.usecaseimpl;

import br.com.curso.application.gateway.TransferGateway;
import br.com.curso.core.domain.Transaction;
import br.com.curso.core.exception.InternalServerErrorException;
import br.com.curso.core.exception.enums.ErrorCodeEnum;
import br.com.curso.usecase.TransferUse;

public class TransferUseImpl implements TransferUse {

    private final TransferGateway transferGateway;

    public TransferUseImpl(TransferGateway transferGateway) {
        this.transferGateway = transferGateway;
    }

    @Override
    public Boolean transfer(Transaction transaction) throws Exception {

        transaction.getFromWallet().transfer(transaction.getValue());
        transaction.getToWallet().receiveValue(transaction.getValue());

        Boolean isTransfer = this.transferGateway.transfer(transaction);

        if(Boolean.FALSE.equals(isTransfer)) {
            throw new InternalServerErrorException(ErrorCodeEnum.TR0003.getMessage(), ErrorCodeEnum.TR0003.getCode());
        }

        return Boolean.TRUE;
    }
    
}
