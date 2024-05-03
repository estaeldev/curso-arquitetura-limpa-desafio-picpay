package br.com.curso.usecase;

import br.com.curso.core.domain.Transaction;

public interface TransferUse {
    
    Boolean transfer(Transaction transaction);

}
