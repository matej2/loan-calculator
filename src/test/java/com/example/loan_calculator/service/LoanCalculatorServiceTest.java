package com.example.loan_calculator.service;

import com.example.loan_calculator.domain.model.LoanOffer;
import com.example.loan_calculator.domain.model.LoanRequest;
import com.example.loan_calculator.util.LoanOfferUtil;
import com.example.loan_calculator.util.LoanRequestUtil;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LoanCalculatorServiceTest {

    private final LoanCalculatorService underTest = new LoanCalculatorService();

    @Test
    void testThatGetMonthlyPaymentReturnsValidResult() {
        LoanOffer loanOffer = LoanOfferUtil.getTestLoanOffer();
        LoanRequest loanRequest = LoanRequestUtil.getTestLoanRequest();

        Float result = underTest.getMonthlyPayment(loanOffer, loanRequest);

        assertThat(result).isEqualTo(42.148);

    }
}