package br.com.curso.application.usecaseimpl;

import br.com.curso.application.gateway.UserNotificationGateway;
import br.com.curso.core.domain.Transaction;
import br.com.curso.core.exception.NotificationException;
import br.com.curso.core.exception.enums.ErrorCodeEnum;
import br.com.curso.usecase.UserNotification;

public class UserNotificationImpl implements UserNotification {

    private final UserNotificationGateway userNotificationGateway;

    public UserNotificationImpl(UserNotificationGateway userNotificationGateway) {
        this.userNotificationGateway = userNotificationGateway;
    }

    @Override
    public void notificate(Transaction transaction, String email) throws NotificationException {
        
        Boolean isNotificate = this.userNotificationGateway.notificate(transaction, email);

        if(Boolean.FALSE.equals(isNotificate)) {
            throw new NotificationException(ErrorCodeEnum.NO0001.getMessage(), ErrorCodeEnum.NO0001.getCode());
        }

    }
    
}
