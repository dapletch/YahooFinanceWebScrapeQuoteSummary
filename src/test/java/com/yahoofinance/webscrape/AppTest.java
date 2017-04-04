package com.yahoofinance.webscrape;

import com.yahoofinance.webscrape.dao.RetrieveRecordsFromMongoDb;
import com.yahoofinance.webscrape.scrapepage.GetQuoteSummary;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {

    private Logger logger = LoggerFactory.getLogger(TestCase.class);
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() {
        assertTrue(true);
    }

    public void testTableAttributeRetrievalTest() {
        GetQuoteSummary getQuoteSummary = new GetQuoteSummary();
        getQuoteSummary.getQuoteSummary("AAPL");
    }

    public void testParseMarketCapConvertToLong() {
        String marketCapStr = "736.59M";
        logger.info("Big Decimal String: " + marketCapStr);
        Integer startpos = 0;
        Integer endpos = marketCapStr.length() - 1;
        logger.info("MarketCap Str: " + marketCapStr.substring(startpos, endpos));
        Double number = Double.parseDouble(marketCapStr.substring(startpos, endpos));
        if (marketCapStr.contains("M")) {
            logger.info(String.valueOf(number.longValue() * 1000000));
        }
        if (marketCapStr.contains("B")) {
            logger.info(String.valueOf(number.longValue() * 1000000000));
        }
    }

    public void testRetrievingRecordsFromMongoUsingDrill() {
        RetrieveRecordsFromMongoDb retrieveRecordsFromMongoDb = new RetrieveRecordsFromMongoDb();
        retrieveRecordsFromMongoDb.printQuoteSummaryObjects(retrieveRecordsFromMongoDb.getQuoteSummariesFromMongoDb());
    }
}
