package com.example.loan_calculator.domain.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class LoanRequest {
    private String type;
    private Long amount;
    private Integer periodMonths;

    private String loanInsurance;
    private Boolean isClient;
}
