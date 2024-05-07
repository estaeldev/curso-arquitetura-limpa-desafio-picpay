package br.com.curso.application.usecaseimpl;

import br.com.curso.application.gateway.EmailAvailableGateway;
import br.com.curso.core.exception.EmailException;
import br.com.curso.core.exception.enums.ErrorCodeEnum;
import br.com.curso.usecase.EmailAvailable;

public class EmailAvailableImpl implements EmailAvailable {

    private final EmailAvailableGateway emailAvailableGateway;

    public EmailAvailableImpl(EmailAvailableGateway emailAvailableGateway) {
        this.emailAvailableGateway = emailAvailableGateway;
    }

    @Override
    public Boolean emailAvailable(String email) throws EmailException {

        if(Boolean.FALSE.equals(this.emailAvailableGateway.emailAvailable(email))) {
            throw new EmailException(ErrorCodeEnum.ON0003.getMessage(), ErrorCodeEnum.ON0003.getCode());
        }
        
        return Boolean.TRUE;
    }
    
}
