package br.com.curso.application.gateway;

import java.math.BigDecimal;

import br.com.curso.core.domain.Wallet;

public interface ConsultBalanceGateway {

    BigDecimal consult(Wallet wallet);
    
}
