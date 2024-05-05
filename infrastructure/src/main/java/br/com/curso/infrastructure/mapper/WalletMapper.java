package br.com.curso.infrastructure.mapper;

import org.springframework.stereotype.Component;

import br.com.curso.core.domain.TransactionPin;
import br.com.curso.core.domain.User;
import br.com.curso.core.domain.Wallet;
import br.com.curso.infrastructure.entity.TransactionPinEntity;
import br.com.curso.infrastructure.entity.UserEntity;
import br.com.curso.infrastructure.entity.WalletEntity;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class WalletMapper {

    private final TransactionPinMapper transactionPinMapper;
    private final UserMapper userMapper;
    
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

    public Wallet toWallet(WalletEntity walletEntity) throws Exception {
        TransactionPin transactionPin = this.transactionPinMapper.toTransactionPin(walletEntity.getTransactionPinEntity());
        User user = this.userMapper.toUser(walletEntity.getUserEntity());
        
        return new Wallet(
                walletEntity.getId(), 
                transactionPin, 
                walletEntity.getBalance(), 
                user, 
                walletEntity.getCreatedAt(), 
                walletEntity.getUpdatedAt()
        );
    }

}
