package com.example.loan_calculator.service;

import com.example.loan_calculator.domain.model.LoanOffer;
import com.example.loan_calculator.domain.model.LoanRequest;
import org.springframework.stereotype.Component;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.stream.IntStream;

@Component
public class LoanCalculatorService {

    private DecimalFormat decimalFormat = new DecimalFormat("#.##");

    // https://stackoverflow.com/a/153785
    public LoanCalculatorService() {
        decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
    }

    // Anuiteta
    // Zaobkroževanje rezultata na dve decimalni mesti: https://stackoverflow.com/a/153753
    public double getMonthlyPayment(LoanOffer loanOffer, LoanRequest loanRequest) throws ParseException {
        float interestRate = 1 + loanOffer.getInterestRate();
        double divident = loanRequest.getAmount()
                * Math.pow(interestRate, loanRequest.getPeriodMonths())
                * (interestRate - 1);
        double divisor = Math.pow(interestRate, loanRequest.getPeriodMonths()) - 1;

        double result = divident / divisor;
        double subtotal = decimalFormat.parse(decimalFormat.format(result)).doubleValue();
        if (loanOffer.getMonthlyCosts() != null) {
            subtotal += loanOffer.getMonthlyCosts();
        }
        return subtotal;
    }

    public double getInterestValueForFirstPayment(LoanOffer loanOffer, LoanRequest loanRequest) {
        return loanRequest.getAmount() * Math.pow(1 + loanOffer.getInterestRate(), 1) - loanRequest.getAmount();
    }

    public double getTotalCosts(LoanOffer loanOffer, LoanRequest loanRequest) throws ParseException {
        return getMonthlyPayment(loanOffer, loanRequest) * loanRequest.getPeriodMonths();
    }
}
