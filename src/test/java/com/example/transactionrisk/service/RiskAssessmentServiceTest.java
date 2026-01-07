package com.example.transactionrisk.service;

import com.example.transactionrisk.model.RiskLevel;
import com.example.transactionrisk.model.Transaction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RiskAssessmentServiceTest {

    private final RiskAssessmentService service = new RiskAssessmentService();

    @Test
    void shouldReturnHighRiskForLargeNonAustralianTransaction() {
        Transaction tx = new Transaction();
        tx.setAmount(15000.0);
        tx.setCountry("US");

        RiskLevel risk = service.assessRisk(tx);

        assertEquals(RiskLevel.HIGH, risk);
    }

    @Test
    void shouldReturnLowRiskForAustralianTransaction() {
        Transaction tx = new Transaction();
        tx.setAmount(15000.0);
        tx.setCountry("AU");

        RiskLevel risk = service.assessRisk(tx);

        assertEquals(RiskLevel.LOW, risk);
    }
}
