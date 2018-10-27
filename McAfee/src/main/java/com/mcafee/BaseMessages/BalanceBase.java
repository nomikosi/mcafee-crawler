package com.mcafee.BaseMessages;

import java.math.BigDecimal;

/**
 *
 * @author nomikosi
 */
public class BalanceBase {
    
    private String Currency;
    private BigDecimal Balance;

    public BalanceBase() {
    }

    public String getCurrency() {
        return Currency;
    }

    public void setCurrency(String Currency) {
        this.Currency = Currency;
    }

    public BigDecimal getBalance() {
        return Balance;
    }

    public void setBalance(BigDecimal Balance) {
        this.Balance = Balance;
    }
    
    
}
