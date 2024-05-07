package br.com.curso.infrastructure.service;

import static br.com.curso.infrastructure.util.LogUtil.LOG;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.curso.application.gateway.UpdateTransactionPinGateway;
import br.com.curso.core.domain.TransactionPin;
import br.com.curso.infrastructure.entity.TransactionPinEntity;
import br.com.curso.infrastructure.mapper.TransactionPinMapper;
import br.com.curso.infrastructure.repository.TransactionPinEntityRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UpdateTransactionPinGatewayImpl implements UpdateTransactionPinGateway {

    private final TransactionPinEntityRepository transactionPinEntityRepository;
    private final TransactionPinMapper transactionPinMapper;

    @Override
    @Transactional
    public TransactionPin update(TransactionPin transactionPin) {
        
        LOG.info("Inicio da atualização da Senha de transação::UpdateTransactionPinGatewayImpl");

        TransactionPinEntity transactionPinEntityUpdate = this.transactionPinEntityRepository
            .save(this.transactionPinMapper.toTransactionPinEntity(transactionPin));

        return this.transactionPinMapper.toTransactionPin(transactionPinEntityUpdate);
    }
    
}
