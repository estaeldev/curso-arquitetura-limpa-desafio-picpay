package br.com.curso.usecase;

import br.com.curso.core.domain.Transaction;
import br.com.curso.core.exception.NotificationException;

public interface UserNotification {

    void notificate(Transaction transaction, String email) throws NotificationException;

}
