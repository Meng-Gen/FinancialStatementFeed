package com.three.cup.cat;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;

public class FinancialStatementFeed {
    public void get(String stockSymbol, DateTime date, boolean isConsolidated) {
        final String url = buildUrl(stockSymbol, date, isConsolidated);
        logger.info(url);
    }

    // Url example: 
    //     http://mops.twse.com.tw/server-java/t164sb01?step=1&CO_ID=2330&SYEAR=2014&SSEASON=4&REPORT_ID=C
    private String buildUrl(String stockSymbol, DateTime date, boolean isConsolidated) {
        final String year = String.valueOf(date.getYear());
        final String season = String.valueOf(getSeason(date));
        final String reportId = isConsolidated ? "C" : "I";
        return String.format(urlTemplate, stockSymbol, year, season, reportId);
    }

    private int getSeason(final DateTime date) {
        final int month = date.getMonthOfYear();
        return (month - 1) / 3 + 1;
    }

    private static final Logger logger = Logger.getLogger(FinancialStatementFeed.class);

    private static final String urlTemplate = "http://mops.twse.com.tw/server-java/t164sb01?" 
            + "step=1&CO_ID=%s&SYEAR=%s&SSEASON=%s&REPORT_ID=%s";
}