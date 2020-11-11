package io.labsit.service;

import io.labsit.model.Transaction;
import io.labsit.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository repository;

    public List<Transaction> findByAccountId(Long accountId) {
        return repository.findAllByAccount_IdOrderByDateDesc(accountId);
    }

    @Transactional
    public Transaction save(Transaction transaction) {
        return repository.save(transaction);
    }
}