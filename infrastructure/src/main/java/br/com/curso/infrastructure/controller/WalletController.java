package br.com.curso.infrastructure.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.curso.core.domain.Wallet;
import br.com.curso.infrastructure.dto.request.TransferRequest;
import br.com.curso.infrastructure.dto.response.BaseResponse;
import br.com.curso.usecase.FindWalletByTaxNumber;
import br.com.curso.usecase.TransferUse;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/wallet")
@RequiredArgsConstructor
public class WalletController {

    private final FindWalletByTaxNumber findWalletByTaxNumber;
    private final TransferUse transferUse;

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

        this.transferUse.transfer(transferRequest.getFromTaxNumber(), 
            transferRequest.getToTaxNumber(), 
            transferRequest.getValue(), 
            transferRequest.getPin());


        return ResponseEntity.status(HttpStatus.OK).body(BaseResponse.builder()
            .success(true)
            .message("Transferência realizada com sucesso")
            .build());

    }


}
