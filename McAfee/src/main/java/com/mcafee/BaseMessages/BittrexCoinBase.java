package com.mcafee.BaseMessages;

/**
 *
 * @author nomikosi
 */
public class BittrexCoinBase {
    
     private String Currency;
        private String CurrencyLong;
        private String MinConfirmation;
        private String TxFee;
        private String IsActive;
        private String CoinType;
        private String BaseAddress;
        private String Notice;

        public BittrexCoinBase() {
        }

        public String getCurrency() {
            return Currency;
        }

        public void setCurrency(String Currency) {
            this.Currency = Currency;
        }

        public String getCurrencyLong() {
            return CurrencyLong;
        }

        public void setCurrencyLong(String CurrencyLong) {
            this.CurrencyLong = CurrencyLong;
        }

        public String getMinConfirmation() {
            return MinConfirmation;
        }

        public void setMinConfirmation(String MinConfirmation) {
            this.MinConfirmation = MinConfirmation;
        }

        public String getTxFee() {
            return TxFee;
        }

        public void setTxFee(String TxFee) {
            this.TxFee = TxFee;
        }

        public String getIsActive() {
            return IsActive;
        }

        public void setIsActive(String IsActive) {
            this.IsActive = IsActive;
        }

        public String getCoinType() {
            return CoinType;
        }

        public void setCoinType(String CoinType) {
            this.CoinType = CoinType;
        }

        public String getBaseAddress() {
            return BaseAddress;
        }

        public void setBaseAddress(String BaseAddress) {
            this.BaseAddress = BaseAddress;
        }

        public String getNotice() {
            return Notice;
        }

        public void setNotice(String Notice) {
            this.Notice = Notice;
        }

    
}
