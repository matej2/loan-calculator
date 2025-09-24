package com.example.loan_calculator.util;

import com.example.loan_calculator.domain.model.LoanRequest;

public class LoanRequestUtil {
    public static LoanRequest getTestLoanRequestMonthlyPayments() {
        return LoanRequest.builder()
                .amount(25_000L)
                .periodMonths(240)
                .build();
    }

    public static LoanRequest getTestLoanRequestYearlyPayments() {
        return LoanRequest.builder()
                .amount(25_000L)
                .periodMonths(5)
                .build();
    }
}
