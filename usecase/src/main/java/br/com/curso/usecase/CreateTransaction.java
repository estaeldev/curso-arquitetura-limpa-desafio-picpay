package br.com.curso.usecase;

import br.com.curso.core.domain.Transaction;

public interface CreateTransaction {
    
    Transaction create(Transaction transaction);

}
