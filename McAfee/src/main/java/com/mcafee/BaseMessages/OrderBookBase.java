package com.mcafee.BaseMessages;

import java.math.BigDecimal;

/**
 *
 * @author nomikosi
 */
public class OrderBookBase {
    
    private BigDecimal Quantity;
    private BigDecimal Rate;

    public OrderBookBase() {
    }

    public BigDecimal getQuantity() {
        return Quantity;
    }

    public void setQuantity(BigDecimal Quantity) {
        this.Quantity = Quantity;
    }

    public BigDecimal getRate() {
        return Rate;
    }

    public void setRate(BigDecimal Rate) {
        this.Rate = Rate;
    }
    
}
