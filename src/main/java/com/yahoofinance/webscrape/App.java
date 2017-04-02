package com.yahoofinance.webscrape;


import com.yahoofinance.webscrape.dao.InsertRecordIntoMongoDb;
import com.yahoofinance.webscrape.scrapepage.GetQuoteSummary;
import com.yahoofinance.webscrape.utils.WebScrapeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 *
 */
public class App {

    private static Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        // validate the input of the NASDAQ ticket symbol to be ran against Yahoo Finance
        // the input must be at least one character long
        if (args.length == 1 && args[0].length() >= 1 && WebScrapeUtils.isYahooUrlValid(args[0])) {
            logger.info("The ticker symbol provided is valid. Proceeding with data Quote Summary retrieval.");
            GetQuoteSummary getQuoteSummary = new GetQuoteSummary();
            InsertRecordIntoMongoDb insertRecordIntoMongoDb = new InsertRecordIntoMongoDb();
            insertRecordIntoMongoDb.inserQuoteSummaryIntoMongoDb(getQuoteSummary.getQuoteSummary(args[0]));
        } else {
            logger.error("The ticker symbol provided was not valid. Please try again. Input Entered: " + args[0]);
            System.exit(0);
        }
    }
}
