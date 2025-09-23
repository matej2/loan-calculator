package com.example.loan_calculator.service;

import com.example.loan_calculator.domain.model.LoanOffer;
import com.example.loan_calculator.domain.model.LoanRequest;
import org.springframework.stereotype.Component;

import java.util.stream.IntStream;

@Component
public class LoanCalculatorService {

    public float getMonthlyPayment(LoanOffer loanOffer, LoanRequest loanRequest) {
        float subtotal = (float) loanRequest.getAmount() / loanRequest.getPeriodMonths() + loanOffer.getMonthlyCosts();
        return subtotal + subtotal * loanOffer.getInterestRate();
    }

    public float getTotalPayment(LoanOffer loanOffer, LoanRequest loanRequest) {
        double monthlyCostsSum = IntStream.range(0, loanRequest.getPeriodMonths())
                .mapToDouble(Double::valueOf)
                .reduce(0, (subtotal, _) -> subtotal + loanOffer.getMonthlyCosts());
        float subtotal = (float) (loanRequest.getAmount() + monthlyCostsSum);
        subtotal += loanOffer.getOneTimeCosts();
        return subtotal + subtotal * loanOffer.getInterestRate();
    }
}
