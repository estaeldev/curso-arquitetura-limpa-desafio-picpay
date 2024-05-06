package br.com.curso.infrastructure.service;

import org.springframework.stereotype.Service;

import br.com.curso.application.gateway.UserNotificationGateway;
import br.com.curso.core.domain.Transaction;

@Service
public class UserNotificationGatewayImpl implements UserNotificationGateway {


    @Override
    public Boolean notificate(Transaction transaction, String email) {
        
        return Boolean.TRUE;
    }
    
}
