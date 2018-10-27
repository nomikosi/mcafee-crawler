package com.mcafee.DTO;

import com.mcafee.BaseMessages.OrderBookBase;

import java.util.List;

/**
 *
 * @author nomikosi
 */
public class OrderBookDTO {
    
    private String success;
    private String message;
    private List<OrderBookBase> result;

    public OrderBookDTO() {
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<OrderBookBase> getResult() {
        return result;
    }

    public void setResult(List<OrderBookBase> result) {
        this.result = result;
    }
    
}
