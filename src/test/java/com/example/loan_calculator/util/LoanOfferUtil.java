package com.example.loan_calculator.util;

import com.example.loan_calculator.domain.model.LoanOffer;

public class LoanOfferUtil {
    public static LoanOffer getTestLoanOffer() {
        return LoanOffer.builder()
                .interestRate(0.028F)
                .oneTimeCosts(580F)
                .monthlyCosts(8.7F)
                .build();
    }
}
