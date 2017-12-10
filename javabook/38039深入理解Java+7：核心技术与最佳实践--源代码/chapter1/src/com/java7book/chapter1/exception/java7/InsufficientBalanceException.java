package com.java7book.chapter1.exception.java7;


import java.math.BigDecimal;

public class InsufficientBalanceException extends LocalizedException {

    private BigDecimal requested;
    private BigDecimal balance;
    private BigDecimal shortage;

    public InsufficientBalanceException(BigDecimal requested, BigDecimal balance) {
        super("INSUFFICIENT_BALANCE_EXCEPTION");
        this.requested = requested;
        this.balance = balance;
        this.shortage = requested.subtract(balance);
    }
    
    public String getLocalizedMessage() {
       return format(balance, requested, shortage);
    }
}
