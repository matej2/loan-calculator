package com.example.loan_calculator.util;

import com.example.loan_calculator.domain.model.LoanRequest;

public class LoanRequestUtil {
    public static LoanRequest getTestLoanRequest() {
        return LoanRequest.builder()
                .amount(10_000L)
                .periodMonths(240)
                .build();
    }
}
