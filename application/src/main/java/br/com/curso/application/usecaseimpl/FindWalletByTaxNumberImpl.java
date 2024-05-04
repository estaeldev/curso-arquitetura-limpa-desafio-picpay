package br.com.curso.application.usecaseimpl;

import java.util.Objects;

import br.com.curso.application.gateway.FindWalletByTaxNumberGateway;
import br.com.curso.core.domain.Wallet;
import br.com.curso.core.exception.NotFoundException;
import br.com.curso.core.exception.enums.ErrorCodeEnum;
import br.com.curso.usecase.FindWalletByTaxNumber;

public class FindWalletByTaxNumberImpl implements FindWalletByTaxNumber {

    private final FindWalletByTaxNumberGateway findWalletByTaxNumberGateway;

    public FindWalletByTaxNumberImpl(FindWalletByTaxNumberGateway findWalletByTaxNumberGateway) {
        this.findWalletByTaxNumberGateway = findWalletByTaxNumberGateway;
    }

    @Override
    public Wallet findWalletByTaxNumber(String taxNumber) throws NotFoundException {
        
        Wallet wallet = this.findWalletByTaxNumberGateway.findWalletByTaxNumber(taxNumber);

        if(Objects.isNull(wallet)) {
            throw new NotFoundException(ErrorCodeEnum.WA0001.getMessage(), ErrorCodeEnum.WA0001.getCode());
        }
        
        return wallet;

    }
    
}
