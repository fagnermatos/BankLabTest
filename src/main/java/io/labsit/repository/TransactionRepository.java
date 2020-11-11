package io.labsit.repository;

import io.labsit.model.Account;
import io.labsit.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findAllByAccount_IdOrderByDateDesc(Long accountId);
}