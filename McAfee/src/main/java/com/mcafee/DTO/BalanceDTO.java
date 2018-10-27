package com.mcafee.DTO;

import com.mcafee.BaseMessages.BalanceBase;

/**
 *
 * @author nomikosi
 */
public class BalanceDTO {
    
    private String success;
    private String message;
    private BalanceBase result;

    public BalanceDTO() {
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

    public BalanceBase getResult() {
        return result;
    }

    public void setResult(BalanceBase result) {
        this.result = result;
    }
}
