package br.com.curso.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.curso.application.gateway.CreateTransactionGateway;
import br.com.curso.application.gateway.FindWalletByTaxNumberGateway;
import br.com.curso.application.gateway.TransactionPinValidateGateway;
import br.com.curso.application.gateway.TransactionValidateGateway;
import br.com.curso.application.gateway.TransferGateway;
import br.com.curso.application.gateway.UpdateTransactionPinGateway;
import br.com.curso.application.gateway.UserNotificationGateway;
import br.com.curso.application.usecaseimpl.CreateTransactionImpl;
import br.com.curso.application.usecaseimpl.FindWalletByTaxNumberImpl;
import br.com.curso.application.usecaseimpl.TransactionPinValidateImpl;
import br.com.curso.application.usecaseimpl.TransactionValidateImpl;
import br.com.curso.application.usecaseimpl.TransferUseImpl;
import br.com.curso.application.usecaseimpl.UpdateTransactionPinImpl;
import br.com.curso.application.usecaseimpl.UserNotificationImpl;
import br.com.curso.usecase.CreateTransaction;
import br.com.curso.usecase.FindWalletByTaxNumber;
import br.com.curso.usecase.TransactionPinValidate;
import br.com.curso.usecase.TransactionValidate;
import br.com.curso.usecase.TransferUse;
import br.com.curso.usecase.UpdateTransactionPin;
import br.com.curso.usecase.UserNotification;

@Configuration
public class WalletConfig {

    @Bean
    FindWalletByTaxNumber findWalletByTaxNumber(FindWalletByTaxNumberGateway findWalletByTaxNumberGateway) {
        return new FindWalletByTaxNumberImpl(findWalletByTaxNumberGateway);
    }

    @Bean
    TransactionValidate transactionValidate(TransactionValidateGateway transactionValidateGateway) {
        return new TransactionValidateImpl(transactionValidateGateway);
    }

    @Bean
    CreateTransaction createTransaction(CreateTransactionGateway createTransactionGateway) {
        return new CreateTransactionImpl(createTransactionGateway);
    }

    @Bean
    UserNotification userNotification(UserNotificationGateway userNotificationGateway) {
        return new UserNotificationImpl(userNotificationGateway);
    }

    @Bean
    UpdateTransactionPin updateTransactionPin(UpdateTransactionPinGateway updateTransactionPinGateway) {
        return new UpdateTransactionPinImpl(updateTransactionPinGateway);
    }
    
    @Bean
    TransactionPinValidate transactionPinValidate(TransactionPinValidateGateway transactionValidateGateway, 
                                                UpdateTransactionPin updateTransactionPin) {

        return new TransactionPinValidateImpl(transactionValidateGateway, updateTransactionPin);
    }
    
    @Bean
    TransferUse transferUse(TransferGateway transferGateway) {

        return new TransferUseImpl(transferGateway);
        
    }

    

}
