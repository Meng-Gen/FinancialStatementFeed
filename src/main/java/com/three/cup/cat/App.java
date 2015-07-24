package com.three.cup.cat;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;

public class App {
    public static void main(String[] args) {
        final FinancialStatementFeed feed = new FinancialStatementFeed();
        final DateTime date = new DateTime(2014, 12, 5, 0, 0);
        feed.get("2330", date, true);
    }

    private static final Logger logger = Logger.getLogger(App.class);
}
