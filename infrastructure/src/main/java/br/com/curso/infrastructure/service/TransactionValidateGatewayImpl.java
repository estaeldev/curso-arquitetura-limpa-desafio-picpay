package br.com.curso.infrastructure.service;

import java.util.Objects;

import org.springframework.stereotype.Service;

import br.com.curso.application.gateway.TransactionValidateGateway;
import br.com.curso.core.domain.Transaction;
import br.com.curso.infrastructure.client.service.ApiValidateService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TransactionValidateGatewayImpl implements TransactionValidateGateway {

    private final ApiValidateService apiValidateService;

    @Override
    public Boolean validate(Transaction transaction) {

        if(Objects.isNull(this.apiValidateService.validate())) {
            return Boolean.FALSE;
        }

        return Boolean.TRUE;

    }
    
}
