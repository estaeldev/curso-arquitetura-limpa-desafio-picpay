package br.com.curso.usecase;

import br.com.curso.core.domain.Wallet;

public interface FindWalletByTaxNumber {

    Wallet findByTaxNumber(String taxNumber);

}
