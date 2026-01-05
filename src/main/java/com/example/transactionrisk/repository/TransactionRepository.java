package com.example.transactionrisk.repository;

import com.example.transactionrisk.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
