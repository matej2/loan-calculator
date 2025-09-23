package com.example.loan_calculator.service;

import com.example.loan_calculator.domain.model.LoanOffer;
import com.example.loan_calculator.domain.model.LoanRequest;
import org.springframework.stereotype.Component;

@Component
public class LoanCalculatorService {

    public Float getMonthlyPayment(LoanOffer loanOffer, LoanRequest loanRequest) {
        long subtotal = loanRequest.getAmount() / loanRequest.getPeriodMonths();
        return (float) subtotal + subtotal * loanOffer.getInterestRate();
//        Integer total = IntStream.range(0, loanRequest.getPeriodMonths())
//                .reduce(0, (subtotal, next) -> subtotal += next);
//        return 1L;
    }
}
