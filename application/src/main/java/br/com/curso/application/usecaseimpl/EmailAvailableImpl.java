package br.com.curso.application.usecaseimpl;

import br.com.curso.application.gateway.EmailAvailableGateway;
import br.com.curso.usecase.EmailAvailable;

public class EmailAvailableImpl implements EmailAvailable {

    private final EmailAvailableGateway emailAvailableGateway;

    public EmailAvailableImpl(EmailAvailableGateway emailAvailableGateway) {
        this.emailAvailableGateway = emailAvailableGateway;
    }

    @Override
    public Boolean emailAvailable(String email) {
        return this.emailAvailableGateway.emailAvailable(email);
    }
    
}
