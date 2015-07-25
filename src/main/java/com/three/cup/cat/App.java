package com.three.cup.cat;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;

public class App {
    public static void main(String[] args) {
        final String stockSymbol = "2330"; 
        final DateTime date = new DateTime(2014, 12, 5, 0, 0);
        final boolean isConsolidated = true;
        final FinancialStatementFeed feed = new FinancialStatementFeed(stockSymbol, date, isConsolidated);
        feed.get();
    }

    private static final Logger logger = Logger.getLogger(App.class);
}
