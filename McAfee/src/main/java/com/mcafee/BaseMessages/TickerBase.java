package com.mcafee.BaseMessages;

import java.math.BigDecimal;

/**
 *
 * @author jackn
 */
public class TickerBase {
    
    private BigDecimal Bid;
    private BigDecimal Ask;
    private BigDecimal Last;

    public TickerBase() {
    }

    public BigDecimal getBid() {
        return Bid;
    }

    public void setBid(BigDecimal Bid) {
        this.Bid = Bid;
    }

    public BigDecimal getAsk() {
        return Ask;
    }

    public void setAsk(BigDecimal Ask) {
        this.Ask = Ask;
    }

    public BigDecimal getLast() {
        return Last;
    }

    public void setLast(BigDecimal Last) {
        this.Last = Last;
    }

   
    
}
