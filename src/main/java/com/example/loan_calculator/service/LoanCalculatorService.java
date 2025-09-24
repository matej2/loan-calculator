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
    public double getMonthlyPaymentNoFees(LoanOffer loanOffer, LoanRequest loanRequest) throws ParseException {
        float interstRate = 1 + loanOffer.getInterestRate();
        double divident = loanRequest.getAmount()
                * Math.pow(interstRate, loanRequest.getPeriodMonths())
                * (interstRate - 1);
        double divisor = Math.pow(interstRate, loanRequest.getPeriodMonths()) - 1;

        double result = divident / divisor;
        double subtotal = decimalFormat.parse(decimalFormat.format(result)).doubleValue();
        if (loanOffer.getMonthlyCosts() != null) {
            subtotal += loanOffer.getMonthlyCosts();
        }
        return subtotal;
    }

    public float getTotalPayment(LoanOffer loanOffer, LoanRequest loanRequest) {
        double monthlyCostsSum = IntStream.range(0, loanRequest.getPeriodMonths())
                .mapToDouble(Double::valueOf)
                .reduce(0, (subtotal, _) -> subtotal + loanOffer.getMonthlyCosts());
        float subtotal = (float) (loanRequest.getAmount() + monthlyCostsSum);
        subtotal += loanOffer.getOneTimeCosts();
        return subtotal + subtotal * loanOffer.getInterestRate();
    }

    public float getTotalCosts(LoanOffer loanOffer, LoanRequest loanRequest) {
        double monthlyCostsSum = IntStream.range(0, loanRequest.getPeriodMonths())
                .mapToDouble(Double::valueOf)
                .reduce(0, (subtotal, _) -> subtotal + loanOffer.getMonthlyCosts());
        float subtotal = (float) (monthlyCostsSum + loanOffer.getOneTimeCosts());
        return subtotal *= loanOffer.getInterestRate();
    }
}
