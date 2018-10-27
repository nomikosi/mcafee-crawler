package com.mcafee.DTO;

import com.mcafee.BaseMessages.TickerBase;

/**
 *
 * @author jackn
 */
public class TickerDTO {
    
    private String success;
    private String message;    
    private TickerBase result;

    public TickerDTO() {      
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

    public TickerBase getResult() {
        return result;
    }

    public void setResult(TickerBase result) {
        this.result = result;
    }
    
}
