package com.mcafee;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 *
 * @author nomikosi
 */
public class StaticInitializer {
    
    public final static String COIN_NOT_FOUND ="NOT_FOUND";
    public final static int TIME_INTERVAL = 1100;
    public final static String BASECOINSYMBOL = "BTC-";
    public final static String TWITTER_PROFILE = "nomikosi";
    public final static String BITTREX_CORRECT_TICKER = "true";
    public static final String SELL_LIMIT_MULTIPLIER = "1.7";
    public static final int ORDERBOOK_STARTING_POSITION = 10;

    public final static Twitter getTwitterSettings() {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("consumerKey")
                .setOAuthConsumerSecret("consumerSecret")
                .setOAuthAccessToken("accessToken")
                .setOAuthAccessTokenSecret("accessTokenSecret");
        TwitterFactory tf = new TwitterFactory(cb.build());
        return tf.getInstance();
    }
    
}
