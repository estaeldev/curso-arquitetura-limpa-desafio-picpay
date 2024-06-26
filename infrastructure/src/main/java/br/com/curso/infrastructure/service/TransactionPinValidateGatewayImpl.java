package br.com.curso.infrastructure.service;

import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.curso.application.gateway.TransactionPinValidateGateway;
import br.com.curso.core.domain.TransactionPin;
import br.com.curso.infrastructure.entity.TransactionPinEntity;
import br.com.curso.infrastructure.repository.TransactionPinEntityRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TransactionPinValidateGatewayImpl implements TransactionPinValidateGateway {

    private final TransactionPinEntityRepository transactionPinEntityRepository;

    @Override
    public Boolean validate(TransactionPin transactionPin, String pin) {
        
        Optional<TransactionPinEntity> transactionPinEntityOpt = 
            this.transactionPinEntityRepository.findById(transactionPin.getId());

        if(!transactionPinEntityOpt.isPresent()) {
            return Boolean.FALSE;
        }

        if(!Objects.equals(transactionPinEntityOpt.get().getPin(), pin)) {
            return Boolean.FALSE;
        }
        
        
        return Boolean.TRUE;
    }
    
}
