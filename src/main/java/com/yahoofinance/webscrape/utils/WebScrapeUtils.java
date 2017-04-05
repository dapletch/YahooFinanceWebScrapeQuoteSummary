package com.yahoofinance.webscrape.utils;

import org.apache.commons.validator.routines.UrlValidator;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Seth on 4/1/2017.
 */
public class WebScrapeUtils {

    private static final String[] schemes = {"http", "https"};
    private static final String dividendYieldRegex = "([+-]?\\d*\\.\\d+)(?![-+0-9\\.]).*?([+-]?\\d*\\.\\d+)(?![-+0-9\\.])";

    private static Logger logger = LoggerFactory.getLogger(WebScrapeUtils.class);

    public static Boolean isYahooUrlValid(String tickerSymbol) {
        UrlValidator urlValidator = new UrlValidator(schemes);
        return urlValidator.isValid("https://finance.yahoo.com/quote/" + tickerSymbol);
    }

    public static Double stringToDouble(String doubleStr) {
        logger.info("Double Str: " + doubleStr);
        if (isStringNonApplicable(doubleStr)) {
            return null;
        }
        return Double.parseDouble(doubleStr);
    }

    public static Double getStockPriceByQuantity(String stockByQuantityStr) {
        if (!isStockPriceAndQuantityNull(stockByQuantityStr)) {
            String[] stockByQuantityArray = stockByQuantityStr.split(" x ");
            logger.info("Stock Price By Quantity: " + stockByQuantityArray[0]);
            return Double.parseDouble(stockByQuantityArray[0]);
        }
        return null;
    }

    public static Integer getStockQuantityByPrice(String stockByPriceStr) {
        if (!isStockPriceAndQuantityNull(stockByPriceStr)) {
            String[] stockByQuantityArray = stockByPriceStr.split(" x ");
            logger.info("Stock Quantity By Price: " + stockByQuantityArray[1]);
            return Integer.parseInt(stockByQuantityArray[1]);
        }
        return null;
    }

    public static Double getStockStartingPrice(String stockRangeStr) {
        if (!isStockPriceAndQuantityNull(stockRangeStr)) {
            String[] stockRangeArray = stockRangeStr.split(" - ");
            logger.info("Stock Starting Price: " + stockRangeArray[0]);
            return Double.parseDouble(stockRangeArray[0]);
        }
        return null;
    }

    private static Boolean isStockPriceAndQuantityNull(String stockPriceAndQuantityStr) {
        return stockPriceAndQuantityStr.trim().equals("0.00 x");
    }

    public static Double getStockEndingPrice(String stockRangeStr) {
        String[] stockRangeArray = stockRangeStr.split(" - ");
        logger.info("Stock Ending Price: " + stockRangeArray[1]);
        return Double.parseDouble(stockRangeArray[1]);
    }

    public static Integer removeCommasReturnInteger(String commaIntStr) {
        String numNoCommas = commaIntStr.replace(",", "");
        return Integer.parseInt(numNoCommas);
    }

    public static Long stringToLong(String marketCapStr) {
        logger.info("Big Decimal String: " + marketCapStr);
        Integer startpos = 0;
        Integer endpos = marketCapStr.length() - 1;
        Double number = Double.parseDouble(marketCapStr.substring(startpos, endpos));
        logger.info("Number Character Removed: " + number);
        if (isStringNonApplicable(marketCapStr)) {
            return null;
        } else if (marketCapStr.contains("M")) {
            return number.longValue() * 1000000;
        } else if (marketCapStr.contains("B")) {
            return number.longValue() * 1000000000;
        } else {
            return number.longValue();
        }
    }

    public static DateTime stringToDateTime(String dateStr) {
        if (!isStringNonApplicable(dateStr)) {
            DateTimeFormatter formatter = DateTimeFormat.forPattern("MMM dd, yyyy");
            return formatter.parseDateTime(dateStr);
        }
        return null;
    }

    public static DateTime getEarningsStartDate(String dateStr) {
        if (!isStringNonApplicable(dateStr)) {
            String[] dateArray = dateStr.split("-");
            logger.info("Start Date Str: " + dateArray[0]);
            return stringToDateTime(dateArray[0].trim());
        }
        return null;
    }

    public static DateTime getEarningsEndDate(String dateStr) {
        if (!isStringNonApplicable(dateStr)) {
            String[] dateArray = dateStr.split("-");
            logger.info("End Date Str: " + dateArray[1]);
            return stringToDateTime(dateArray[1].trim());
        }
        return null;
    }

    // Creating this method to return an array for using regular expressions like this can be memory intensive
    // and creating two separate  methods would be redundant
    public static String[] getDividendYieldArray(String dividendYieldStr) {
        if (!isStringNonApplicable(dividendYieldStr)) {
            String[] dividendYieldArray = null;
            Pattern pattern = Pattern.compile(dividendYieldRegex, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
            Matcher matcher = pattern.matcher(dividendYieldStr);
            if (matcher.find()) {
                dividendYieldArray = new String[]{matcher.group(1), matcher.group(2)};
            }
            return dividendYieldArray;
        }
        return null;
    }

    private static Boolean isStringNonApplicable(String naStr) {
        return naStr.trim().equals("N/A") || naStr.trim().equals("N/A (N/A)");
    }

    // TODO look into a better way of converting DateTime to Date - this was the only way that seemed to work
    public static Date dateTimeToDate(DateTime dateTime) {
        if (dateTime != null) {
            return new Date(String.valueOf(dateTime));
        }
        return null;
    }

    public static DateTime sqlDateToDateTime(String dateStr) {
        logger.info("DateStr: " + dateStr);
        if (dateStr != null) {
            return DateTime.parse(dateStr, DateTimeFormat.forPattern("yyyy-MM-dd")).toDateTime();
        }
        return null;
    }

}