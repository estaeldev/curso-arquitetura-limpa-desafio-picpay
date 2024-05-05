package br.com.curso.usecase;

import br.com.curso.core.domain.Wallet;
import br.com.curso.core.exception.NotFoundException;

public interface FindWalletByTaxNumber {

    Wallet findWalletByTaxNumber(String taxNumber) throws NotFoundException, Exception;

}
