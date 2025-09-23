package com.example.loan_calculator.domain.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class LoanOffer {
    private final Float interestRate;
    private final Float oneTimeCosts;
    private final Float monthlyCosts;
}
