package br.com.curso.application.usecaseimpl;

import java.math.BigDecimal;

import br.com.curso.application.gateway.ConsultBalanceGateway;
import br.com.curso.core.domain.Wallet;
import br.com.curso.usecase.ConsultBalance;

public class ConsultBalanceImpl implements ConsultBalance {

    private final ConsultBalanceGateway consultBalanceGateway;

    public ConsultBalanceImpl(ConsultBalanceGateway consultBalanceGateway) {
        this.consultBalanceGateway = consultBalanceGateway;
    }

    @Override
    public BigDecimal consult(Wallet wallet) {

        return consultBalanceGateway.consult(wallet);

    }

}
