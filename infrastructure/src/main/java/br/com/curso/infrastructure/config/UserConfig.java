package br.com.curso.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.curso.application.gateway.CreateUserGateway;
import br.com.curso.application.gateway.EmailAvailableGateway;
import br.com.curso.application.gateway.TaxNumberAvailableGateway;
import br.com.curso.application.usecaseimpl.CreateUserImpl;
import br.com.curso.application.usecaseimpl.EmailAvailableImpl;
import br.com.curso.application.usecaseimpl.TaxNumberAvailableImpl;
import br.com.curso.usecase.CreateUser;
import br.com.curso.usecase.EmailAvailable;
import br.com.curso.usecase.TaxNumberAvailable;

@Configuration
public class UserConfig {

    @Bean
    TaxNumberAvailable taxNumberAvailable(TaxNumberAvailableGateway taxNumberAvailableGateway) {
        return new TaxNumberAvailableImpl(taxNumberAvailableGateway);
    }

    @Bean
    EmailAvailable emailAvailable(EmailAvailableGateway emailAvailableGateway) {
        return new EmailAvailableImpl(emailAvailableGateway);
    }
    
    @Bean
    CreateUser createUser(TaxNumberAvailable taxNumberAvailable, EmailAvailable emailAvailable,
            CreateUserGateway createUserGateway) {
        return new CreateUserImpl(taxNumberAvailable, emailAvailable, createUserGateway);
    }


}
