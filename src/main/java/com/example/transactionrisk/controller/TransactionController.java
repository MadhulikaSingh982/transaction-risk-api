package com.example.transactionrisk.controller;

import com.example.transactionrisk.exception.ResourceNotFoundException;
import com.example.transactionrisk.model.Transaction;
import com.example.transactionrisk.repository.TransactionRepository;
import com.example.transactionrisk.service.RiskAssessmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/{id}")
    public Transaction getById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Transaction NOT Found"));
    }

    @GetMapping
    public List<Transaction> getByRisk(@RequestParam String risk) {
        return repository.findByRisk(risk);
    }
}
