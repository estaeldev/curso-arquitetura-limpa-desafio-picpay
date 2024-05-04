package br.com.curso.application.usecaseimpl;

import br.com.curso.application.gateway.UserAuthenticateGateway;
import br.com.curso.core.exception.AuthenticationException;
import br.com.curso.core.exception.enums.ErrorCodeEnum;
import br.com.curso.usecase.UserAuthenticate;

public class UserAuthenticateImpl implements UserAuthenticate {

    private final UserAuthenticateGateway userAuthenticateGateway;

    public UserAuthenticateImpl(UserAuthenticateGateway userAuthenticateGateway) {
        this.userAuthenticateGateway = userAuthenticateGateway;
    }

    @Override
    public Boolean authenticate(String username, String password) throws AuthenticationException {

        Boolean isAuthenticate = this.userAuthenticateGateway.authenticate(username, password);

        if(Boolean.FALSE.equals(isAuthenticate)) {
            throw new AuthenticationException(ErrorCodeEnum.ATH0001.getMessage(), ErrorCodeEnum.ATH0001.getCode());
        }

        return true;

    }
    
}
