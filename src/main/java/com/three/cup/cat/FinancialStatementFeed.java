package com.three.cup.cat;

import org.apache.log4j.Logger;

public class FinancialStatementFeed {
    public void get(String stockSymbol, String date, boolean isConsolidated) {
        logger.info(stockSymbol);
        logger.info(date);
        logger.info(isConsolidated);
    }

    private static final Logger logger = Logger.getLogger(FinancialStatementFeed.class);
}