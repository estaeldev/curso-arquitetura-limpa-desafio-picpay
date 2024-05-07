package br.com.curso.application.usecaseimpl;

import java.math.BigDecimal;

import br.com.curso.application.gateway.CreateUserGateway;
import br.com.curso.core.domain.TransactionPin;
import br.com.curso.core.domain.User;
import br.com.curso.core.domain.Wallet;
import br.com.curso.core.exception.EmailException;
import br.com.curso.core.exception.InternalServerErrorException;
import br.com.curso.core.exception.TaxNumberException;
import br.com.curso.core.exception.TransactionPinException;
import br.com.curso.core.exception.enums.ErrorCodeEnum;
import br.com.curso.usecase.CreateUser;

public class CreateUserImpl implements CreateUser {

    private final CreateUserGateway createUserGateway;

    public CreateUserImpl(CreateUserGateway createUserGateway) {
        this.createUserGateway = createUserGateway;
    }

    @Override
    public void create(User user, String pin) 
        throws TaxNumberException, EmailException, TransactionPinException, InternalServerErrorException  {

        Boolean isUserSaved = this.createUserGateway.create(user, new Wallet(BigDecimal.ZERO, user, new TransactionPin(pin)));
        
        if(Boolean.FALSE.equals(isUserSaved)) {
            throw new InternalServerErrorException(ErrorCodeEnum.ON0004.getMessage(), ErrorCodeEnum.ON0004.getCode());
        }
        
    }
    

}
