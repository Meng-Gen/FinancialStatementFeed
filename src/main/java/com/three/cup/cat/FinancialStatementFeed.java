package com.three.cup.cat;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class FinancialStatementFeed {
    public FinancialStatementFeed(String stockSymbol, DateTime date, boolean isConsolidated) {
        this.stockSymbol = stockSymbol;
        this.year = String.valueOf(date.getYear());
        this.season = String.valueOf(FeedUtils.getDateTimeSeason(date));
        this.reportId = isConsolidated ? "C" : "I";
    }

    public void get() {
        final String urlSpec = buildUrlSpec();
        logger.info(urlSpec);

        final String pathname = buildPathname();
        logger.info(pathname);

        FeedUtils.copyUrlToFile(urlSpec, pathname);

    }

    // example: http://mops.twse.com.tw/server-java/t164sb01?step=1&CO_ID=2330&SYEAR=2014&SSEASON=4&REPORT_ID=C
    private String buildUrlSpec() {
        return String.format(urlTemplate, stockSymbol, year, season, reportId);
    }

    private String buildPathname() {
        final String filename = String.format(filenameTemplate, stockSymbol, year, season, reportId);
        return dataDir + filename;
    }

    private static final Logger logger = Logger.getLogger(FinancialStatementFeed.class);

    private static final String urlTemplate = "http://mops.twse.com.tw/server-java/t164sb01?" 
            + "step=1&CO_ID=%s&SYEAR=%s&SSEASON=%s&REPORT_ID=%s";

    // TODO: move to config file
    private static final String filenameTemplate = "%s_%s_%s_%s.html";

    // TODO: move to config file
    private static final String dataDir = "/Users/taiwansoong/Documents/FinancialStatementFeed/data/";

    private final String stockSymbol;

    private final String year;
        
    private final String season;
        
    private final String reportId;
}