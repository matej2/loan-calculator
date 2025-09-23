package com.example.loan_calculator.service;

import com.example.loan_calculator.domain.model.LoanOffer;
import com.example.loan_calculator.domain.model.LoanRequest;
import org.springframework.stereotype.Component;

@Component
public class LoanCalculatorService {

    public float getMonthlyPayment(LoanOffer loanOffer, LoanRequest loanRequest) {
        float subtotal = (float) loanRequest.getAmount() / loanRequest.getPeriodMonths() + loanOffer.getMonthlyCosts();
        return subtotal + subtotal * loanOffer.getInterestRate();
    }
}
