package com.example.loan_calculator.util;

import com.example.loan_calculator.domain.model.LoanOffer;

public class LoanOfferUtil {
    public static LoanOffer getTestLoanOffer() {
        return LoanOffer.builder()
                .interestRate(2.8F)
                .build();
    }
}
