package br.com.curso.infrastructure.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.curso.core.domain.Transaction;
import br.com.curso.core.domain.Wallet;
import br.com.curso.infrastructure.dto.request.TransferRequest;
import br.com.curso.infrastructure.dto.response.BaseResponse;
import br.com.curso.usecase.CreateTransaction;
import br.com.curso.usecase.FindWalletByTaxNumber;
import br.com.curso.usecase.TransactionPinValidate;
import br.com.curso.usecase.TransactionValidate;
import br.com.curso.usecase.TransferUse;
import br.com.curso.usecase.UserNotification;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/wallet")
@RequiredArgsConstructor
public class WalletController {

    private final FindWalletByTaxNumber findWalletByTaxNumber;
    private final TransferUse transferUse;
    private final CreateTransaction createTransaction;
    private final TransactionValidate transactionValidate;
    private final TransactionPinValidate transactionPinValidate;
    private final UserNotification userNotification;

    @GetMapping("/consult-balance/{taxNumber}")
    public ResponseEntity<BaseResponse<?>> consultBalance(@PathVariable final String taxNumber) throws Exception {

        Wallet wallet = this.findWalletByTaxNumber.findWalletByTaxNumber(taxNumber);

        return ResponseEntity.status(HttpStatus.OK).body(BaseResponse.builder()
            .success(true)
            .result(wallet.getBalance())
            .build());

    }

    @PostMapping("/transfer")
    public ResponseEntity<BaseResponse<?>> transfer(@RequestBody final TransferRequest transferRequest) throws Exception {

        Wallet fromWallet = this.findWalletByTaxNumber.findWalletByTaxNumber(transferRequest.getFromTaxNumber());
        this.transactionPinValidate.validate(fromWallet.getTransactionPin(), transferRequest.getPin());

        Wallet toWallet = this.findWalletByTaxNumber.findWalletByTaxNumber(transferRequest.getToTaxNumber());

        Transaction transactionCreate = this.createTransaction.create(fromWallet, toWallet, transferRequest.getValue());

        this.transactionValidate.validate(transactionCreate);
        
        this.transferUse.transfer(transactionCreate);
        
        this.userNotification.notificate(transactionCreate, fromWallet.getUser().getEmail());

        return ResponseEntity.status(HttpStatus.OK).body(BaseResponse.builder()
            .success(true)
            .message("Transferência realizada com sucesso")
            .build());

    }


}
