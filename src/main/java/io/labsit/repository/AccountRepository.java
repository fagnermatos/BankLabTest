package io.labsit.repository;

import io.labsit.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    Account findByNumberAndAgency_Number(Long account, Integer agency);
}