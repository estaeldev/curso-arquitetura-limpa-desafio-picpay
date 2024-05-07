package br.com.curso.usecase;

import java.math.BigDecimal;

import br.com.curso.core.domain.Transaction;
import br.com.curso.core.domain.Wallet;
import br.com.curso.core.exception.TransferException;

public interface CreateTransaction {
    
    Transaction create(Wallet fromWallet, Wallet toWallet, BigDecimal value) throws TransferException;

}
