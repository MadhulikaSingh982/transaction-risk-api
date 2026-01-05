package com.example.transactionrisk.controller;

import com.example.transactionrisk.model.Transaction;
import com.example.transactionrisk.repository.TransactionRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionRepository repository;

    public TransactionController(TransactionRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Transaction create(@RequestBody Transaction transaction) {
        transaction.setRisk("LOW");
        return repository.save(transaction);
    }

    @GetMapping
    public String health() {
        return "Transaction Risk API is running";
    }
}
