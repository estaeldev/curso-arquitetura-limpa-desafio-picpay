package br.com.curso.usecase;

import java.math.BigDecimal;

public interface TransferUse {
    
    Boolean transfer(String fromTaxNumber, String toTaxNumber, BigDecimal value);

}
