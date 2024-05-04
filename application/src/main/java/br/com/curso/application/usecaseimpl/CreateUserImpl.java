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
import br.com.curso.usecase.EmailAvailable;
import br.com.curso.usecase.TaxNumberAvailable;

public class CreateUserImpl implements CreateUser {

    private final TaxNumberAvailable taxNumberAvailable;
    private final EmailAvailable emailAvailable;
    private final CreateUserGateway createUserGateway;

    public CreateUserImpl(TaxNumberAvailable taxNumberAvailable, EmailAvailable emailAvailable,
            CreateUserGateway createUserGateway) {
        this.taxNumberAvailable = taxNumberAvailable;
        this.emailAvailable = emailAvailable;
        this.createUserGateway = createUserGateway;
    }

    @Override
    public void create(User user, String pin) 
        throws TaxNumberException, EmailException, TransactionPinException, InternalServerErrorException  {

        if(Boolean.FALSE.equals(this.taxNumberAvailable.taxNumberAvailable(user.getTaxNumber().getValue()))) {
            throw new TaxNumberException(ErrorCodeEnum.ON0002.getMessage(), ErrorCodeEnum.ON0002.getCode());
        }

        if(Boolean.FALSE.equals(this.emailAvailable.emailAvailable(user.getEmail()))) {
            throw new EmailException(ErrorCodeEnum.ON0003.getMessage(), ErrorCodeEnum.ON0003.getCode());
        }

        Boolean isUserSaved = this.createUserGateway.create(user, new Wallet(BigDecimal.ZERO, user, new TransactionPin(pin)));
        
        if(Boolean.FALSE.equals(isUserSaved)) {
            throw new InternalServerErrorException(ErrorCodeEnum.ON0004.getMessage(), ErrorCodeEnum.ON0004.getCode());
        }
        
    }
    

}
