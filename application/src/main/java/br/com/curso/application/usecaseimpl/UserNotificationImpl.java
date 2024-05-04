package br.com.curso.application.usecaseimpl;

import br.com.curso.application.gateway.UserNotificationGateway;
import br.com.curso.core.domain.Transaction;
import br.com.curso.usecase.UserNotification;

public class UserNotificationImpl implements UserNotification {

    private final UserNotificationGateway userNotificationGateway;

    public UserNotificationImpl(UserNotificationGateway userNotificationGateway) {
        this.userNotificationGateway = userNotificationGateway;
    }

    @Override
    public Boolean notificate(Transaction transaction, String email) {
        
        return this.userNotificationGateway.notificate(transaction, email);

    }
    
}
