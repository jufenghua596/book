package com.java7book.chapter1.exception;

import java.math.BigDecimal;

public class InsufficientBalanceException extends Exception {

    private BigDecimal requested;
    private BigDecimal balance;
    private BigDecimal shortage;

    public InsufficientBalanceException(BigDecimal requested, BigDecimal balance) {
        this.requested = requested;
        this.balance = balance;
        this.shortage = requested.subtract(balance);
    }
}
