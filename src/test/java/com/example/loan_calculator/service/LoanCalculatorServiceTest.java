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

    LoanOffer loanOffer = LoanOfferUtil.getTestLoanOffer();
    LoanOffer loanOfferSimple = LoanOfferUtil.getTestLoanOfferSimple();

    LoanRequest loanRequestMonthly = LoanRequestUtil.getTestLoanRequestMonthlyPayments();
    LoanRequest loanRequestYearly = LoanRequestUtil.getTestLoanRequestYearlyPayments();

    @Test
    void testThatGetMonthlyPaymentIncludingFeesReturnsValidResult() throws ParseException {
        double result = underTest.getMonthlyPaymentNoFees(loanOfferSimple, loanRequestMonthly);

        assertThat(result).isEqualTo(58.37);

    }

    @Test
    void testThatGetYearlyPaymentForInitialPeriodReturnsValidResult() throws ParseException {
        double result = underTest.getMonthlyPaymentNoFees(loanOfferSimple, loanRequestYearly);

        assertThat(result).isEqualTo(5934.91);
    }

    @Test
    void testThatGetTotalPaymentReturnsValidResult() {
        Float result = underTest.getTotalPayment(loanOffer, loanRequestMonthly);

        assertThat(result).isEqualTo(15738.89);
    }

    @Test
    void getTotalCosts() {
        Float result = underTest.getTotalCosts(loanOffer, loanRequestMonthly);

        assertThat(result).isEqualTo(5738.89);
    }
}