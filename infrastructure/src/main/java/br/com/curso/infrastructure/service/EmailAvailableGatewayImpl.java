package br.com.curso.infrastructure.service;

import static br.com.curso.infrastructure.util.LogUtil.LOG;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.curso.application.gateway.EmailAvailableGateway;
import br.com.curso.infrastructure.repository.UserEntityRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmailAvailableGatewayImpl implements EmailAvailableGateway {

    private final UserEntityRepository userEntityRepository;

    @Override
    @Transactional(readOnly = true)
    public Boolean emailAvailable(String email) {

        LOG.info("Inicio da verificação se o Email está disponível::EmailAvailableGatewayImpl");

        return !this.userEntityRepository.existsByEmail(email);

    }
    
}
