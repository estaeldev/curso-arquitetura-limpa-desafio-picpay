package br.com.curso.infrastructure.service;

import static br.com.curso.infrastructure.util.LogUtil.LOG;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.curso.application.gateway.TaxNumberAvailableGateway;
import br.com.curso.infrastructure.repository.UserEntityRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TaxNumberAvailableGatewayImpl implements TaxNumberAvailableGateway {

    private final UserEntityRepository userEntityRepository;

    @Override
    @Transactional(readOnly = true)
    public Boolean taxNumberAvailable(String taxNumber) {

        LOG.info("Inicio da verificação se o TaxNumber está disponível::TaxNumberAvailableGatewayImpl");
        
        return !this.userEntityRepository.existsByTaxNumber(taxNumber);
        
    }

    
    
}
