package br.com.curso.usecase;

import java.math.BigDecimal;

import br.com.curso.core.domain.Wallet;

public interface ConsultBalance {
    
    BigDecimal consult(Wallet wallet);

}
