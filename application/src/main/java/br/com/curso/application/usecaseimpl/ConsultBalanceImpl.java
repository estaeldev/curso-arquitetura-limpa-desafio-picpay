package br.com.curso.application.usecaseimpl;

import java.math.BigDecimal;

import br.com.curso.core.domain.Wallet;
import br.com.curso.usecase.ConsultBalance;
import br.com.curso.usecase.FindWalletByTaxNumber;

public class ConsultBalanceImpl implements ConsultBalance {

    private final FindWalletByTaxNumber findWalletByTaxNumber;

    public ConsultBalanceImpl(FindWalletByTaxNumber findWalletByTaxNumber) {
        this.findWalletByTaxNumber = findWalletByTaxNumber;
    }

    @Override
    public BigDecimal consult(String taxNumber) throws Exception {
        
        Wallet wallet = this.findWalletByTaxNumber.findWalletByTaxNumber(taxNumber);
        return wallet.getBalance();

    }

}
