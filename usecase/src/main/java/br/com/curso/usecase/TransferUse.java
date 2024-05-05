package br.com.curso.usecase;

import java.math.BigDecimal;

import br.com.curso.core.exception.InternalServerErrorException;
import br.com.curso.core.exception.NotFoundException;
import br.com.curso.core.exception.NotificationException;
import br.com.curso.core.exception.PinException;
import br.com.curso.core.exception.TransferException;

public interface TransferUse {
    
    Boolean transfer(String fromTaxNumber, String toTaxNumber, BigDecimal value, String pin)
        throws InternalServerErrorException, TransferException, NotFoundException, NotificationException, PinException, Exception;

}
