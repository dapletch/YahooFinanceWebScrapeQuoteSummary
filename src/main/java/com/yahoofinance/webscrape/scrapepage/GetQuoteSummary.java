package com.yahoofinance.webscrape.scrapepage;

import com.yahoofinance.webscrape.beans.QuoteSummary;
import com.yahoofinance.webscrape.utils.WebScrapeUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Created by Seth on 4/1/2017.
 */
public class GetQuoteSummary {

    private Logger logger = LoggerFactory.getLogger(GetQuoteSummary.class);
    private String cssQuery = "td[class=\"Ta(end) Fw(b)\"]";

    public QuoteSummary getQuoteSummary(String tickerSymbol) {
        try {
            Document doc = Jsoup.connect("https://finance.yahoo.com/quote/" + tickerSymbol).get();
            QuoteSummary quoteSummary = new QuoteSummary();
            quoteSummary.setPreviousClosingPrice(WebScrapeUtils.stringToDouble(doc.select(cssQuery).get(0).text()));
            quoteSummary.setOpeningPrice(WebScrapeUtils.stringToDouble(doc.select(cssQuery).get(1).text()));

            // The bidOffer, and bidQuantity are both in the same field in the HTML table, so they must be parsed in order to be retrieved
            quoteSummary.setBidOffer(WebScrapeUtils.getStockPriceByQuantity(doc.select(cssQuery).get(2).text()));
            quoteSummary.setBidQuantity(WebScrapeUtils.getStockQuantityByPrice(doc.select(cssQuery).get(2).text()));

            // The askingPrice, and askingQuantity are both in the same field in the HTML table, so they must be parsed in order to be retrieved
            quoteSummary.setAskingPrice(WebScrapeUtils.getStockPriceByQuantity(doc.select(cssQuery).get(3).text()));
            quoteSummary.setAskingQuantity(WebScrapeUtils.getStockQuantityByPrice(doc.select(cssQuery).get(3).text()));

            // The daysRangeStart and daysRangeEnd are both in the same field in the HTML table, so they will need to be parsed
            quoteSummary.setDaysRangeStart(WebScrapeUtils.getStockStartingPrice(doc.select(cssQuery).get(4).text()));
            quoteSummary.setDaysRangeEnd(WebScrapeUtils.getStockEndingPrice(doc.select(cssQuery).get(4).text()));

            // The same is true for the 52 Week Range
            quoteSummary.setFiftyWeekRangeStart(WebScrapeUtils.getStockStartingPrice(doc.select(cssQuery).get(5).text()));
            quoteSummary.setFiftyWeekRangeEnd(WebScrapeUtils.getStockEndingPrice(doc.select(cssQuery).get(5).text()));

            // remove the commas from both the volume and avgVolume variables
            quoteSummary.setVolume(WebScrapeUtils.removeCommasReturnInteger(doc.select(cssQuery).get(6).text()));
            quoteSummary.setAvgVolume(WebScrapeUtils.removeCommasReturnInteger(doc.select(cssQuery).get(7).text()));

            quoteSummary.setMarketCap(WebScrapeUtils.stringToBigDecimal(doc.select(cssQuery).get(8).text()));
            quoteSummary.setBeta(WebScrapeUtils.stringToDouble(doc.select(cssQuery).get(9).text()));
            quoteSummary.setPeRatioTtm(WebScrapeUtils.stringToDouble(doc.select(cssQuery).get(10).text()));
            quoteSummary.setEpsTtm(WebScrapeUtils.stringToDouble(doc.select(cssQuery).get(11).text()));
            quoteSummary.setEarningsDateStart(WebScrapeUtils.getEarningsStartDate(doc.select(cssQuery).get(12).text()));
            quoteSummary.setGetEarningsDateEnd(WebScrapeUtils.getEarningsEndDate(doc.select(cssQuery).get(12).text()));

            //TODO Still need to account for the dividend, yield, ex-dividend date, and first year target estimate

            logger.info("QuoteSummary String: " + quoteSummary.toString());
            logger.info("QuoteSummary HashCode: " + quoteSummary.hashCode());
        } catch (IOException e) {
            logger.error("An error occurred while trying to retrieve the information from Yahoo Finance: \n" + e);
        }
        return null;
    }
}