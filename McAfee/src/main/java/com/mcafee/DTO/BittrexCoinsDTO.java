package com.mcafee.DTO;

import com.mcafee.BaseMessages.BittrexCoinBase;

import java.util.List;

/**
 *
 * @author nomikosi
 */
public class BittrexCoinsDTO {

    private String success;
    private String message;
    private List<BittrexCoinBase> result;
    
    public BittrexCoinsDTO() {
    }

    public List<BittrexCoinBase> getResult() {
        return result;
    }

    public void setResult(List<BittrexCoinBase> result) {
        this.result = result;
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
}
