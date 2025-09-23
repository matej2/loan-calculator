package com.example.loan_calculator.service;

import com.example.loan_calculator.domain.model.LoanOffer;
import com.example.loan_calculator.domain.model.LoanRequest;
import org.springframework.stereotype.Component;

@Component
public class LoanCalculatorService {

    public Long getMonthlyPayment(LoanRequest loanRequest) {
        return 1L;
    }
}
