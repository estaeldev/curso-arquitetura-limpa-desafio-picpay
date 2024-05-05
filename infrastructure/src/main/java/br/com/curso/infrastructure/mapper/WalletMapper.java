package br.com.curso.infrastructure.mapper;

import org.springframework.stereotype.Component;

import br.com.curso.core.domain.Wallet;
import br.com.curso.infrastructure.entity.TransactionPinEntity;
import br.com.curso.infrastructure.entity.UserEntity;
import br.com.curso.infrastructure.entity.WalletEntity;

@Component
public class WalletMapper {
    
    public WalletEntity toWalletEntity(Wallet wallet, UserEntity userEntity, TransactionPinEntity transactionPinEntity) {
        return new WalletEntity(
            wallet.getId(), 
            transactionPinEntity, 
            wallet.getBalance(), 
            userEntity, 
            wallet.getCreatedAt(), 
            wallet.getUpdateAt()
        );
    }

}
