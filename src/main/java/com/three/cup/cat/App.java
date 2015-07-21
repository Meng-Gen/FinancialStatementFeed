package com.three.cup.cat;

import org.apache.log4j.Logger;

public class App {
    public static void main(String[] args) {
        final FinancialStatementFeed feed = new FinancialStatementFeed();
        feed.get("2330", "2014-12-31", true);
    }

    private static final Logger logger = Logger.getLogger(App.class);
}
