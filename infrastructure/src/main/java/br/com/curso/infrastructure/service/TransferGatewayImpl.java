package br.com.curso.infrastructure.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.curso.application.gateway.TransferGateway;
import br.com.curso.core.domain.Transaction;
import br.com.curso.infrastructure.entity.TransactionEntity;
import br.com.curso.infrastructure.mapper.TransactionMapper;
import br.com.curso.infrastructure.mapper.WalletMapper;
import br.com.curso.infrastructure.repository.TransactionEntityRepository;
import br.com.curso.infrastructure.repository.WalletEntityRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TransferGatewayImpl implements TransferGateway {

    private final WalletEntityRepository walletEntityRepository;
    private final TransactionEntityRepository transactionEntityRepository;
    private final WalletMapper walletMapper;
    private final TransactionMapper transactionMapper;

    @Override   
    @Transactional
    public Boolean transfer(Transaction transaction) {

        try {
            
            this.walletEntityRepository.save(this.walletMapper.toWalletEntity(transaction.getFromWallet()));
            this.walletEntityRepository.save(this.walletMapper.toWalletEntity(transaction.getToWallet()));
    
            TransactionEntity transactionEntity = this.transactionMapper.concludeTransaction(transaction);
            this.transactionEntityRepository.save(transactionEntity);
            
            
            return Boolean.TRUE;
            
        } catch (Exception e) {
            TransactionEntity transactionEntity = this.transactionMapper.cancelTransaction(transaction);
            this.transactionEntityRepository.save(transactionEntity);
            return Boolean.FALSE;
        }   
        
    }
    
}
