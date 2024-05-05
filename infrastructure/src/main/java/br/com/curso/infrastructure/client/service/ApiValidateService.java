package br.com.curso.infrastructure.client.service;

import org.springframework.stereotype.Service;

import br.com.curso.infrastructure.client.ApiValidateClient;
import br.com.curso.infrastructure.client.dto.response.ApiValidateResponse;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ApiValidateService {

    private final ApiValidateClient apiValidateClient;


    public ApiValidateResponse validate() {

        try {
            return this.apiValidateClient.validate();
        } catch (Exception e) {
            return null;
        }

    }
    
}
