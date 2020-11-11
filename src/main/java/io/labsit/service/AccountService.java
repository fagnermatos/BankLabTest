package io.labsit.service;

import io.labsit.model.Account;
import io.labsit.model.KindTransaction;
import io.labsit.model.Transaction;
import io.labsit.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

import static io.labsit.model.KindTransaction.DEPOSIT;
import static io.labsit.model.KindTransaction.WITHDRAW;
import static io.labsit.model.Transaction.of;
import static io.vavr.API.Try;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository repository;
    private final TransactionService transactionService;

    @Transactional
    public void withdraw(Integer agencyNumber,
                         Long accountNumber,
                         BigDecimal value) {
        Account account = findBy(agencyNumber, accountNumber);
        account.setBalance(account.getBalance().subtract(value));
        transactionService.save(of(value, WITHDRAW, account));
    }

    @Transactional
    public void deposit(Integer agencyNumber,
                        Long accountNumber,
                        BigDecimal value) {
        Account account = findBy(agencyNumber, accountNumber);
        account.setBalance(account.getBalance().add(value));
        transactionService.save(of(value, DEPOSIT, account));
    }

    public BigDecimal balance(Integer agencyNumber,
                        Long accountNumber) {
        return findBy(agencyNumber, accountNumber).getBalance();
    }

    public List<Transaction> statement(Integer agencyNumber,
                                       Long accountNumber) {
        return transactionService.findByAccountId(findBy(agencyNumber, accountNumber).getId());
    }

    private Account findBy(Integer agencyNumber,
                           Long accountNumber) {
        return Try(() -> repository.findByNumberAndAgency_Number(accountNumber, agencyNumber))
                .filter(Objects::nonNull)
                .getOrElseThrow(() -> {
                    throw new ResponseStatusException(NOT_FOUND, "Conta não encontrada!");
                });
    }
}