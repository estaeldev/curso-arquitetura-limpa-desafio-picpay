package br.com.curso.usecase;

import java.math.BigDecimal;

import br.com.curso.core.exception.NotFoundException;

public interface ConsultBalance {
    
    BigDecimal consult(String taxNumber) throws NotFoundException, Exception;

}
