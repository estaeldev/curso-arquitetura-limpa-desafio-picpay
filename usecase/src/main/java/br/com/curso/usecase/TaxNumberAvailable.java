package br.com.curso.usecase;

import br.com.curso.core.exception.TaxNumberException;

public interface TaxNumberAvailable {
    
    Boolean taxNumberAvailable(String taxNumber) throws TaxNumberException;

}
