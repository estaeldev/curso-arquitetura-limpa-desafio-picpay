package br.com.curso.infrastructure.service;

import static br.com.curso.infrastructure.util.LogUtil.LOG;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.curso.application.gateway.CreateUserGateway;
import br.com.curso.core.domain.User;
import br.com.curso.core.domain.Wallet;
import br.com.curso.infrastructure.entity.TransactionPinEntity;
import br.com.curso.infrastructure.entity.UserEntity;
import br.com.curso.infrastructure.mapper.TransactionPinMapper;
import br.com.curso.infrastructure.mapper.UserMapper;
import br.com.curso.infrastructure.mapper.WalletMapper;
import br.com.curso.infrastructure.repository.TransactionPinEntityRepository;
import br.com.curso.infrastructure.repository.UserEntityRepository;
import br.com.curso.infrastructure.repository.WalletEntityRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CreateUserGatewayImpl implements CreateUserGateway {

    private final UserEntityRepository userEntityRepository;
    private final TransactionPinEntityRepository transactionPinEntityRepository;
    private final WalletEntityRepository walletEntityRepository;
    private final UserMapper userMapper;
    private final TransactionPinMapper transactionPinMapper;
    private final WalletMapper walletMapper;
    

    @Override
    @Transactional
    public Boolean create(User user, Wallet wallet) {

        try {
            
            LOG.info("Inicio da criação do usuário::CreateUserGatewayImpl");

            UserEntity userSaved = this.userEntityRepository.save(this.userMapper.toUserEntity(user));
            TransactionPinEntity transactionPinSaved = this.transactionPinEntityRepository.save(this.transactionPinMapper.
                toTransactionPinEntity(wallet.getTransactionPin()));
            this.walletEntityRepository.save(this.walletMapper.toWalletEntity(wallet, userSaved, transactionPinSaved));

            LOG.info("Usuário criado com sucesso::CreateUserGatewayImpl");

            return Boolean.TRUE;

        } catch (Exception e) {
            LOG.error("Houve um erro na criação do usuário::CreateUserGatewayImpl");
            return Boolean.FALSE;
        }
        
    }
    
}
