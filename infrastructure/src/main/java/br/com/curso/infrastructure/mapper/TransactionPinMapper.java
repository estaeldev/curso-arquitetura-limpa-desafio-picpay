package br.com.curso.infrastructure.mapper;

import org.springframework.stereotype.Component;

import br.com.curso.core.domain.TransactionPin;
import br.com.curso.infrastructure.entity.TransactionPinEntity;

@Component
public class TransactionPinMapper {
    
    public TransactionPinEntity toTransactionPinEntity(TransactionPin transactionPin) {
        return new TransactionPinEntity(
            transactionPin.getId(), 
            transactionPin.getPin(), 
            transactionPin.getAttempt(), 
            transactionPin.getBlocked(), 
            transactionPin.getCreatedAt(), 
            transactionPin.getUpdateAt()
        );
    }
    
}
