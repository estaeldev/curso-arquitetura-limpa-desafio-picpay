package br.com.curso.infrastructure.mapper;

import org.springframework.stereotype.Component;

import br.com.curso.core.domain.Transaction;
import br.com.curso.core.domain.Wallet;
import br.com.curso.core.domain.enums.TransactionStatusEnum;
import br.com.curso.infrastructure.entity.TransactionEntity;
import br.com.curso.infrastructure.entity.WalletEntity;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class TransactionMapper {

    private final WalletMapper walletMapper;

    public TransactionEntity toTransactionEntity(Transaction transaction) {

        WalletEntity fromWalletEntity = this.walletMapper.toWalletEntity(transaction.getFromWallet());
        WalletEntity toWalletEntity = this.walletMapper.toWalletEntity(transaction.getToWallet());

        return new TransactionEntity(
            transaction.getId(), 
            fromWalletEntity, 
            toWalletEntity, 
            transaction.getValue(), 
            transaction.getStatus(), 
            transaction.getCreatedAt(), 
            transaction.getUpdateAt()
        );
    }

    public TransactionEntity concludeTransaction(Transaction transaction) {

        WalletEntity fromWalletEntity = this.walletMapper.toWalletEntity(transaction.getFromWallet());
        WalletEntity toWalletEntity = this.walletMapper.toWalletEntity(transaction.getToWallet());

        return new TransactionEntity(
            transaction.getId(), 
            fromWalletEntity, 
            toWalletEntity, 
            transaction.getValue(), 
            TransactionStatusEnum.SUCCESS, 
            transaction.getCreatedAt(), 
            transaction.getUpdateAt()
        );
    }

    public TransactionEntity cancelTransaction(Transaction transaction) {

        WalletEntity fromWalletEntity = this.walletMapper.toWalletEntity(transaction.getFromWallet());
        WalletEntity toWalletEntity = this.walletMapper.toWalletEntity(transaction.getToWallet());

        return new TransactionEntity(
            transaction.getId(), 
            fromWalletEntity, 
            toWalletEntity, 
            transaction.getValue(), 
            TransactionStatusEnum.CANCELED, 
            transaction.getCreatedAt(), 
            transaction.getUpdateAt()
        );
    }

    public TransactionEntity createTransactionEntity(Transaction transaction) {

        WalletEntity fromWalletEntity = this.walletMapper.toWalletEntity(transaction.getFromWallet());
        WalletEntity toWalletEntity = this.walletMapper.toWalletEntity(transaction.getToWallet());

        return new TransactionEntity(
            transaction.getId(), 
            fromWalletEntity, 
            toWalletEntity, 
            transaction.getValue(), 
            TransactionStatusEnum.CREATED, 
            transaction.getCreatedAt(), 
            transaction.getUpdateAt()
        );
    }

    public Transaction toTransaction(TransactionEntity transactionEntity) throws Exception {

        Wallet fromWallet = this.walletMapper.toWallet(transactionEntity.getFromWalletEntity());
        Wallet toWallet = this.walletMapper.toWallet(transactionEntity.getToWalletEntity());
        
        return new Transaction(
            transactionEntity.getId(),
            fromWallet, 
            toWallet, 
            transactionEntity.getValue(), 
            transactionEntity.getStatus(), 
            transactionEntity.getCreatedAt(), 
            transactionEntity.getUpdatedAt()
        );
    }

}
