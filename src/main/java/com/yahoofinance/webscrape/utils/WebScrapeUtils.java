package com.yahoofinance.webscrape.utils;

import org.apache.commons.validator.routines.UrlValidator;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

/**
 * Created by Seth on 4/1/2017.
 */
public class WebScrapeUtils {

    private static final String[] schemes = {"http", "https"};

    private static Logger logger = LoggerFactory.getLogger(WebScrapeUtils.class);

    public static Boolean isYahooUrlValid(String tickerSymbol) {
        UrlValidator urlValidator = new UrlValidator(schemes);
        return urlValidator.isValid("https://finance.yahoo.com/quote/" + tickerSymbol);
    }

    public static Double stringToDouble(String doubleStr) {
        logger.info("Double Str: " + doubleStr);
        return Double.parseDouble(doubleStr);
    }

    public static Integer stringToInteger(String intStr) {
        logger.info("Integer Str: " + intStr);
        return Integer.parseInt(intStr);
    }

    public static Double getStockPriceByQuantity(String stockByQuantityStr) {
        String[] stockByQuantityArray = stockByQuantityStr.split("x");
        logger.info("Stock Price By Quantity: " + stockByQuantityArray[0]);
        return Double.parseDouble(stockByQuantityArray[0]);
    }

    public static Integer getStockQuantityByPrice(String stockByPriceStr) {
        String[] stockByQuantityArray = stockByPriceStr.split("x");
        logger.info("Stock Quantity By Price: " + stockByQuantityArray[1]);
        return Integer.parseInt(stockByQuantityArray[1]);
    }

    public static Double getStockStartingPrice(String stockRangeStr) {
        String[] stockRangeArray = stockRangeStr.split("-");
        logger.info("Stock Starting Price: " + stockRangeArray[0]);
        return Double.parseDouble(stockRangeArray[0]);
    }

    public static Double getStockEndingPrice(String stockRangeStr) {
        String[] stockRangeArray = stockRangeStr.split("-");
        logger.info("Stock Ending Price: " + stockRangeArray[1]);
        return Double.parseDouble(stockRangeArray[1]);
    }

    public static Integer removeCommasReturnInteger(String commaIntStr) {
        String numNoCommas = commaIntStr.replace(",", "");
        return Integer.parseInt(numNoCommas);
    }

    public static BigDecimal stringToBigDecimal(String bigDecimalStr) {
        logger.info("Big Decimal String: " + bigDecimalStr);
        Integer startpos = bigDecimalStr.length() - 1;
        Integer endpos = bigDecimalStr.length();
        Double number = Double.parseDouble(bigDecimalStr.substring(startpos, endpos));
        if (bigDecimalStr.contains("M")) {
            return new BigDecimal(number * 1000000);
        }
        if (bigDecimalStr.contains("B")) {
            return new BigDecimal(number * 1000000000);
        }
        return new BigDecimal(number);
    }

    private static DateTime stringToDateTime(String dateStr) {
        DateTimeFormatter formatter = DateTimeFormat.forPattern("MMM dd, yyyy");
        return formatter.parseDateTime(dateStr);
    }

    public static DateTime getEarningsStartDate(String dateStr) {
        String[] dateArray = dateStr.split("-");
        logger.info("Start Date Str: " + dateArray[0]);
        return stringToDateTime(dateArray[0].trim());
    }

    public static DateTime getEarningsEndDate(String dateStr) {
        String[] dateArray = dateStr.split("-");
        logger.info("End Date Str: " + dateArray[1]);
        return stringToDateTime(dateArray[1].trim());
    }
}