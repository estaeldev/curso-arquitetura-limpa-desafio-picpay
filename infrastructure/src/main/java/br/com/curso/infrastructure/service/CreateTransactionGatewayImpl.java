package br.com.curso.infrastructure.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.curso.application.gateway.CreateTransactionGateway;
import br.com.curso.core.domain.Transaction;
import br.com.curso.infrastructure.entity.TransactionEntity;
import br.com.curso.infrastructure.mapper.TransactionMapper;
import br.com.curso.infrastructure.repository.TransactionEntityRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CreateTransactionGatewayImpl implements CreateTransactionGateway {

    private final TransactionEntityRepository transactionEntityRepository;
    private final TransactionMapper transactionMapper;

    @Override
    @Transactional
    public Transaction create(Transaction transaction) {

        try {
            
            TransactionEntity transactionEntity = this.transactionMapper.createTransactionEntity(transaction);
            TransactionEntity transactionEntitySaved = this.transactionEntityRepository.save(transactionEntity);
            return this.transactionMapper.toTransaction(transactionEntitySaved);
            
        } catch (Exception e) {
            return null;
        }

    }

}
