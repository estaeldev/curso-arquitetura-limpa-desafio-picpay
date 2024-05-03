package br.com.curso.usecase;

import br.com.curso.core.domain.Transaction;

public interface UserNotification {
    Boolean notificate(Transaction transaction, String email);
}
