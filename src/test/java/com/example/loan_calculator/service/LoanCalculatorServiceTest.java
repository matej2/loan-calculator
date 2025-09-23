package com.example.loan_calculator.service;

import com.example.loan_calculator.domain.model.LoanRequest;
import com.example.loan_calculator.util.LoanOfferUtil;
import com.example.loan_calculator.util.LoanRequestUtil;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LoanCalculatorServiceTest {

    private final LoanCalculatorService underTest = new LoanCalculatorService();

    @Test
    void testThatGetMonthlyPaymentReturnsValidResult() {
        LoanRequest loanRequest = LoanRequestUtil.getTestLoanRequest();
        Long result = underTest.getMonthlyPayment(loanRequest);

        assertThat(result).isEqualTo(58.37);

    }
}