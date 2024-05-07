package br.com.curso.application.usecaseimpl;

import br.com.curso.application.gateway.TaxNumberAvailableGateway;
import br.com.curso.core.exception.TaxNumberException;
import br.com.curso.core.exception.enums.ErrorCodeEnum;
import br.com.curso.usecase.TaxNumberAvailable;

public class TaxNumberAvailableImpl implements TaxNumberAvailable {

    private final TaxNumberAvailableGateway taxNumberAvailableGateway;

    public TaxNumberAvailableImpl(TaxNumberAvailableGateway taxNumberAvailableGateway) {
        this.taxNumberAvailableGateway = taxNumberAvailableGateway;
    }

    @Override
    public Boolean taxNumberAvailable(String taxNumber) throws TaxNumberException {

        if(Boolean.FALSE.equals(this.taxNumberAvailableGateway.taxNumberAvailable(taxNumber))) {
            throw new TaxNumberException(ErrorCodeEnum.ON0002.getMessage(), ErrorCodeEnum.ON0002.getCode());
        }   
        
        return Boolean.TRUE;
    }
    
}
