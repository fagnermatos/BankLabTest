package io.labsit.api;

import io.labsit.model.Transaction;
import io.labsit.service.AccountService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@Api("contas")
@RequiredArgsConstructor
@RequestMapping("contas")
public class AccountResource {

    private final AccountService service;

    @PutMapping("saque")
    @ResponseStatus(OK)
    public void withdraw(@RequestParam("agencia") Integer agencyNumber,
                       @RequestParam("conta") Long accountNumber,
                       @RequestParam("valor") BigDecimal value) {
        service.withdraw(agencyNumber, accountNumber, value);
    }

    @PutMapping("deposito")
    @ResponseStatus(OK)
    public void deposit(@RequestParam("agencia") Integer agencyNumber,
                       @RequestParam("conta") Long accountNumber,
                       @RequestParam("valor") BigDecimal value) {
        service.deposit(agencyNumber, accountNumber, value);
    }

    @PutMapping("saldo")
    @ResponseStatus(OK)
    public BigDecimal balance(@RequestParam("agencia") Integer agencyNumber,
                              @RequestParam("conta") Long accountNumber) {
        return service.balance(agencyNumber, accountNumber);
    }

    @PutMapping("extrato")
    @ResponseStatus(OK)
    public List<Transaction> statement(@RequestParam("agencia") Integer agencyNumber,
                                       @RequestParam("conta") Long accountNumber) {
        return service.statement(agencyNumber, accountNumber);
    }
}
