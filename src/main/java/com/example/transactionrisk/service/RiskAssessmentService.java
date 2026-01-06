package com.example.transactionrisk.service;

import com.example.transactionrisk.model.Transaction;
import org.springframework.stereotype.Service;

@Service
public class RiskAssessmentService {

    public String assessRisk(Transaction transaction) {
        if (transaction.getAmount() > 10000 && !"AU".equalsIgnoreCase(transaction.getCountry())) {
            return "HIGH";
        }
        return "LOW";
    }
}
