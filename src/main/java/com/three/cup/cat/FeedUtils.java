package com.three.cup.cat;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class FeedUtils {
    public static int getDateTimeSeason(final DateTime date) {
        final int month = date.getMonthOfYear();
        return (month - 1) / 3 + 1;
    }

    public static void copyUrlToFile(String urlSpec, String pathname) {
        try {
            final URL url = new URL(urlSpec);
            final File file = new File(pathname);
            FileUtils.copyURLToFile(url, file);
        } catch (final MalformedURLException e) {
            // TODO: write log to database
        } catch (final IOException e) {
            // TODO: write log to database
        }
    }

    private static final Logger logger = Logger.getLogger(FeedUtils.class);
}