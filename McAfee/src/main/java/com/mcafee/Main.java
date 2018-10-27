package com.mcafee;

import com.google.gson.Gson;
import com.mcafee.BittrexConnector.Bittrex;
import com.mcafee.DTO.BittrexCoinsDTO;

import java.util.Timer;

/**
 *
 * @author nomikosi
 */
public class Main {


    public static void main(String[] args) {
        BittrexCoinsDTO bittrexCoinListings =  getBittrexCoinListings();
        Timer time = new Timer();
        ScheduledTask st = new ScheduledTask(bittrexCoinListings);
        time.schedule(st, 0, StaticInitializer.TIME_INTERVAL);
    }

    public static BittrexCoinsDTO getBittrexCoinListings() {
        Bittrex bittrex = new Bittrex();
        Gson gson = new Gson();
        return gson.fromJson(bittrex.getCurrencies(), BittrexCoinsDTO.class);
    }

}
