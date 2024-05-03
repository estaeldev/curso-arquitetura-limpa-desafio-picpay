package br.com.curso.application.usecaseimpl;

import br.com.curso.application.gateway.TaxNumberAvailableGateway;
import br.com.curso.usecase.TaxNumberAvailable;

public class TaxNumberAvailableImpl implements TaxNumberAvailable {

    private TaxNumberAvailableGateway taxNumberAvailableGateway;

    public TaxNumberAvailableImpl(TaxNumberAvailableGateway taxNumberAvailableGateway) {
        this.taxNumberAvailableGateway = taxNumberAvailableGateway;
    }

    @Override
    public Boolean taxNumberAvailable(String taxNumber) {
        return this.taxNumberAvailableGateway.taxNumberAvailable(taxNumber);
    }
    
}
