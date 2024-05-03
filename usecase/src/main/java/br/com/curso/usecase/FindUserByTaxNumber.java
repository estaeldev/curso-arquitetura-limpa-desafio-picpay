package br.com.curso.usecase;

import br.com.curso.core.domain.User;

public interface FindUserByTaxNumber {

    User findByTaxNumber(String taxNumber);

}
