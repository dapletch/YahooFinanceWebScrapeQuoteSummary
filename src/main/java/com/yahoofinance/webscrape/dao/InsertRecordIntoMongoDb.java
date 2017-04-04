package com.yahoofinance.webscrape.dao;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import com.yahoofinance.webscrape.beans.QuoteSummary;
import com.yahoofinance.webscrape.utils.WebScrapeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Seth on 4/2/2017.
 */
public class InsertRecordIntoMongoDb {

    private Logger logger = LoggerFactory.getLogger(InsertRecordIntoMongoDb.class);

    public void inserQuoteSummaryIntoMongoDb(QuoteSummary quoteSummary) {

        //TODO will need to create a properties file that holds in the appropriate values and use that to establish the connection
        //TODO will check into configuring this functionality using Spring this seems extremely tedious
        Mongo mongo = new Mongo("localhost", 27017);
        DB db = mongo.getDB("yahoo_finance");

        DBCollection collection = db.getCollection("yahoo_finance");
        logger.info("Basic MongoDB Example...");
        BasicDBObject document = new BasicDBObject();
        document.put("ticker_symbol", quoteSummary.getTickerSymbol());
        document.put("prv_close_price", quoteSummary.getPreviousClosingPrice());
        document.put("opening_price", quoteSummary.getOpeningPrice());

        // Detail for bid object in the yahoo_finance collection
        BasicDBObject bid = new BasicDBObject();
        bid.put("offer", quoteSummary.getBidOffer());
        bid.put("quantity", quoteSummary.getBidQuantity());
        document.put("bid", bid);

        // Detail for the asking_price object
        BasicDBObject askingPrice = new BasicDBObject();
        askingPrice.put("price", quoteSummary.getAskingPrice());
        askingPrice.put("quantity", quoteSummary.getAskingQuantity());
        document.put("asking_price", askingPrice);

        // Detail for the day_range object
        BasicDBObject dayRange = new BasicDBObject();
        dayRange.put("start", quoteSummary.getDaysRangeStart());
        dayRange.put("end", quoteSummary.getDaysRangeEnd());
        document.put("day_range", dayRange);

        // Detail for fifty_wk_range object
        BasicDBObject fiftyTwoWkRange = new BasicDBObject();
        fiftyTwoWkRange.put("start", quoteSummary.getFiftyWeekRangeStart());
        fiftyTwoWkRange.put("end", quoteSummary.getFiftyWeekRangeEnd());
        document.put("fifty_wk_range", fiftyTwoWkRange);

        document.put("volume", quoteSummary.getVolume());
        document.put("avg_volume", quoteSummary.getAvgVolume());
        document.put("market_cap", quoteSummary.getMarketCap());
        document.put("beta", quoteSummary.getBeta());
        document.put("pe_ratio_ttm", quoteSummary.getPeRatioTtm());
        document.put("eps_ttm", quoteSummary.getEpsTtm());

        // Detail for earnings_dt object
        BasicDBObject earningsDt = new BasicDBObject();
        earningsDt.put("start_dt", WebScrapeUtils.dateTimeToDate(quoteSummary.getEarningsDateStart()));
        earningsDt.put("end_dt", WebScrapeUtils.dateTimeToDate(quoteSummary.getGetEarningsDateEnd()));
        document.put("earnings_dt", earningsDt);

        // Detail for dividend_yield object
        BasicDBObject dividendYield = new BasicDBObject();
        dividendYield.put("dividend", quoteSummary.getDividend());
        dividendYield.put("yield", quoteSummary.getYield());
        document.put("dividend_yield", dividendYield);

        document.put("ex_dividend_dt", WebScrapeUtils.dateTimeToDate(quoteSummary.getExDividendDate()));
        document.put("first_year_target", quoteSummary.getFirstYearEstimate());
        document.put("entered_dt", quoteSummary.getDateEntered());

        // Inserting the record
        collection.insert(document);
    }
}
