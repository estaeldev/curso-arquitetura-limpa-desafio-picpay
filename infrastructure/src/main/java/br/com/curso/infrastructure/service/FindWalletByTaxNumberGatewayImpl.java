package br.com.curso.infrastructure.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.curso.application.gateway.FindWalletByTaxNumberGateway;
import br.com.curso.core.domain.Wallet;
import br.com.curso.infrastructure.entity.WalletEntity;
import br.com.curso.infrastructure.mapper.WalletMapper;
import br.com.curso.infrastructure.repository.WalletEntityRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FindWalletByTaxNumberGatewayImpl implements FindWalletByTaxNumberGateway {

    private final WalletEntityRepository walletEntityRepository;
    private final WalletMapper walletMapper;

    @Override
    @Transactional(readOnly = true)
    public Wallet findWalletByTaxNumber(String taxNumber) throws Exception {
        
        Optional<WalletEntity> walletEntityOptional = this.walletEntityRepository.findByUserEntityTaxNumber(taxNumber);
        
        if(walletEntityOptional.isPresent()) {
            return this.walletMapper.toWallet(walletEntityOptional.get());
        }

        return null;
        
    }
    
}
