package com.example.loan_calculator.service;

import com.example.loan_calculator.domain.model.LoanOffer;
import com.example.loan_calculator.domain.model.LoanRequest;
import com.example.loan_calculator.util.LoanOfferUtil;
import com.example.loan_calculator.util.LoanRequestUtil;
import org.junit.jupiter.api.Test;

import java.text.ParseException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LoanCalculatorServiceTest {

    private final LoanCalculatorService underTest = new LoanCalculatorService();

    LoanOffer loanOfferA = LoanOfferUtil.getTestLoanOffer();
    LoanOffer loanOfferB = LoanOfferUtil.getTestLoanOfferSimple();

    LoanRequest loanRequestLong = LoanRequestUtil.getTestLoanRequestMonthlyPayments();
    LoanRequest loanRequestShort = LoanRequestUtil.getTestLoanRequestYearlyPayments();

    @Test
    void testThatGetMonthlyPaymentReturnsValidResult() throws ParseException {
        double result = underTest.getMonthlyPayment(loanOfferA, loanRequestLong);

        assertThat(result).isEqualTo(58.37);
    }

    @Test
    void testThatGetMonthlyPaymentForShortPeriodReturnsValidResult() throws ParseException {
        double result = underTest.getMonthlyPayment(loanOfferB, loanRequestShort);

        assertThat(result).isEqualTo(5934.91);
    }

    @Test
    void getTotalCosts() throws ParseException {
        double result = underTest.getTotalCosts(loanOfferA, loanRequestLong);

        assertThat(result).isEqualTo(5738.89);
    }
}