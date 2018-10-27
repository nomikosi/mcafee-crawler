/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcafee;

import com.google.gson.Gson;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mcafee.BaseMessages.OrderBookBase;
import com.mcafee.BittrexConnector.Bittrex;
import com.mcafee.DTO.BalanceDTO;
import com.mcafee.DTO.BittrexCoinsDTO;
import com.mcafee.DTO.OrderBookDTO;
import com.mcafee.DTO.TickerDTO;
import twitter4j.Twitter;
import twitter4j.TwitterException;

/**
 * @author nomikosi
 */
public class ScheduledTask extends TimerTask {


    public static final Logger LOGGER = Logger.getLogger(ScheduledTask.class.getName());
    private final BittrexCoinsDTO coinListings;


    public ScheduledTask(BittrexCoinsDTO coinListings) {
        this.coinListings = coinListings;
    }

    @Override
    public void run() {


        String coin = crawlTwitterForCoin();
        if (StaticInitializer.COIN_NOT_FOUND.equals(coin)) {

        } else {
            BigDecimal coinPrice = getCoinAskPrice(coin);
            LOGGER.log(Level.INFO, "Coin price: " + coinPrice.toString());
            BigDecimal btcBalance = getBalance("BTC");

            LOGGER.log(Level.INFO, "My Balance:"+ btcBalance.toString());
            createBuyOrder(btcBalance, coin);
            createSellLimit(coinPrice, coin);
            throw new RuntimeException("Program executed... Terminated");
        }


    }

    private String crawlTwitterForCoin() {
        try {
            Twitter twitter = StaticInitializer.getTwitterSettings();
            TwitterPosts twitterPosts = new TwitterPosts();
            return twitterPosts.findCoinFromTwitterPosts(twitter, coinListings, StaticInitializer.TWITTER_PROFILE);
        } catch (TwitterException ex) {
            throw new RuntimeException(ex);
        }
    }

    private void createSellLimit(BigDecimal initialCoinPrice, String coin) {
        String coinMarket = StaticInitializer.BASECOINSYMBOL + coin;
        Bittrex wrapper = new Bittrex();
        BigDecimal quantity = getBalance(coin);
        LOGGER.log(Level.INFO, coinMarket + " " + quantity.toString() + " " + initialCoinPrice.multiply(new BigDecimal(StaticInitializer.SELL_LIMIT_MULTIPLIER)).toString());
        String orderResponse = wrapper.sellLimit(coinMarket, quantity.toString(), initialCoinPrice.multiply(new BigDecimal(StaticInitializer.SELL_LIMIT_MULTIPLIER)).toString());
        LOGGER.log(Level.INFO, orderResponse);
    }

    private void createBuyOrder(BigDecimal availableBalance, String coin) {
        Bittrex bittrex = new Bittrex();
        Gson gson = new Gson();
        String coinTicker = StaticInitializer.BASECOINSYMBOL + coin;
        OrderBookDTO orderBook = gson.fromJson(bittrex.getOrderBook(coinTicker, Bittrex.ORDERBOOK_SELL), OrderBookDTO.class);
        String orderResponse;
        String quantity;

        for (OrderBookBase order : orderBook.getResult().subList(StaticInitializer.ORDERBOOK_STARTING_POSITION, orderBook.getResult().size())) {

            quantity = (availableBalance).divide(order.getRate(), 0, RoundingMode.FLOOR).toString();
            orderResponse = bittrex.buyLimit(coinTicker, quantity, order.getRate().toString());
            LOGGER.log(Level.INFO, orderResponse);

            availableBalance = getBalance("BTC");
            if (availableBalance.compareTo(new BigDecimal(0.0001)) < 0) {
                return;
            }

        }
    }

    private BigDecimal getCoinAskPrice(String coin) {
        Bittrex bittrex = new Bittrex();
        String coinTicker = StaticInitializer.BASECOINSYMBOL + coin;
        Gson gson = new Gson();
        TickerDTO ticker = gson.fromJson(bittrex.getTicker(coinTicker), TickerDTO.class);

        if (StaticInitializer.BITTREX_CORRECT_TICKER.equals(ticker.getSuccess())) {
            return ticker.getResult().getLast();
        }


        throw new RuntimeException("Ticker failed");

    }

    private BigDecimal getBalance(String coin) {
        Bittrex wrapper = new Bittrex();
        Gson gson = new Gson();
        BalanceDTO balance = gson.fromJson(wrapper.getBalance(coin), BalanceDTO.class);
        return balance.getResult().getBalance() == null? BigDecimal.ZERO: balance.getResult().getBalance();
    }


}
