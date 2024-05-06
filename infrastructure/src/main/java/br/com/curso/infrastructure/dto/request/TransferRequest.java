package br.com.curso.infrastructure.dto.request;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TransferRequest {
    
    String fromTaxNumber; 
    String toTaxNumber; 
    BigDecimal value; 
    String pin;

}
