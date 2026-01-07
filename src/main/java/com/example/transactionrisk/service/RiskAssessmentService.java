package com.example.transactionrisk.service;

import com.example.transactionrisk.model.RiskLevel;
import com.example.transactionrisk.model.Transaction;
import org.springframework.stereotype.Service;

@Service
public class RiskAssessmentService {

    public RiskLevel assessRisk(Transaction transaction) {
        if (transaction.getAmount() > 10000 && !"AU".equalsIgnoreCase(transaction.getCountry())) {
            return RiskLevel.HIGH;
        }
        return RiskLevel.LOW;
    }
}
