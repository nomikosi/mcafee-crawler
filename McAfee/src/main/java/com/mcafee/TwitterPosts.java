package com.mcafee;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.mcafee.DTO.BittrexCoinsDTO;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;

/**
 *
 * @author nomikosi
 */
public class TwitterPosts {


    private static final Logger LOGGER = Logger.getLogger(TwitterPosts.class.getName());

    public String findCoinFromTwitterPosts(Twitter twitter, BittrexCoinsDTO coinListings, String userTimeline) throws TwitterException {

        List<Status> statuses = twitter.getUserTimeline(userTimeline);
        Pattern regex  = Pattern.compile("[A-Z]{2,}");

        for (Status status : statuses) {

            String coin = findCoinSymbol(status.getText(),regex);

            if (StaticInitializer.COIN_NOT_FOUND.equals(coin)) {
                continue;
            }

            if (!coinsToIgnore(coin) && isCoinInBittrex(coin, coinListings)) {
                LOGGER.log(Level.INFO,"Found coin: "+ coin);
                return coin;
            }

        }
        return StaticInitializer.COIN_NOT_FOUND;
    }

    private boolean isCoinInBittrex(String coin, BittrexCoinsDTO coinListings) {

        return coinListings.getResult().stream().anyMatch((coinBase) -> (coinBase.getCurrency().equalsIgnoreCase(coin) || coinBase.getCurrencyLong().equalsIgnoreCase(coin)));
    }

    private boolean coinsToIgnore(String coin) {

        switch (coin) {
            case "BTC":
                return true;
            default:
                return false;
        }

    }

    private static String findCoinSymbol(String s,Pattern regex) {

        Matcher regexMatcher = regex.matcher(s);
        while (regexMatcher.find()) {
            return regexMatcher.group();
        }
        return StaticInitializer.COIN_NOT_FOUND;
    }

}
