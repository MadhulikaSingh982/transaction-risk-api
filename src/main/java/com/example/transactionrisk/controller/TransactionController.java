package com.example.transactionrisk.controller;

import com.example.transactionrisk.model.Transaction;
import com.example.transactionrisk.repository.TransactionRepository;
import com.example.transactionrisk.service.RiskAssessmentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionRepository repository;
    private final RiskAssessmentService riskService;

    public TransactionController(TransactionRepository repository, RiskAssessmentService riskService) {
        this.repository = repository;
        this.riskService = riskService;
    }

    @PostMapping
    public Transaction create(@RequestBody Transaction transaction) {
        String risk = riskService.assessRisk(transaction);
        transaction.setRisk(risk);
        return repository.save(transaction);
    }

    @GetMapping
    public String health() {
        return "Transaction Risk API is running";
    }
}
