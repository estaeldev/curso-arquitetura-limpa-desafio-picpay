package br.com.curso.usecase;

import br.com.curso.core.domain.Transaction;

public interface TransactionValidate {
    
    Boolean validate(Transaction transaction);

}
