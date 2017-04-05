package com.yahoofinance.webscrape.dao;

import com.yahoofinance.webscrape.beans.QuoteSummary;
import com.yahoofinance.webscrape.utils.WebScrapeUtils;
import org.apache.drill.jdbc.DrillConnection;
import org.apache.drill.jdbc.Driver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Seth on 4/3/2017.
 */
public class RetrieveRecordsFromMongoDb {

    private Logger logger = LoggerFactory.getLogger(RetrieveRecordsFromMongoDb.class);
    private List<QuoteSummary> quoteSummaryList = new ArrayList<QuoteSummary>();
    // url for format for apache drill installed via embedded mode, the format would be different if the format was distributed
    private String url = "jdbc:drill:drillbit=localhost";

    private String query = "select b.ticker_symbol\n" +
            ", b.prv_close_price\n" +
            ", b.opening_price\n" +
            ", b.bid.offer as bid_offer\n" +
            ", b.bid.quantity as bid_quantity\n" +
            ", b.asking_price.price as asking_price\n" +
            ", b.asking_price.quantity as asking_quantity\n" +
            ", b.day_range.`start` as day_range_start\n" +
            ", b.day_range.`end` as day_range_end\n" +
            ", b.fifty_wk_range.`start` as fifty_wk_range_start\n" +
            ", b.fifty_wk_range.`end` as fifty_wk_range_end\n" +
            ", b.volume\n" +
            ", b.avg_volume\n" +
            ", b.market_cap\n" +
            ", b.beta\n" +
            ", b.pe_ratio_ttm\n" +
            ", b.eps_ttm\n" +
            ", b.earnings_dt.start_dt as earnings_dt_start\n" +
            ", b.earnings_dt.end_dt as earnings_dt_end\n" +
            ", b.dividend_yield.dividend as dividend\n" +
            ", b.dividend_yield.yield as yield\n" +
            ", b.ex_dividend\n" +
            ", b.first_year_target\n" +
            // I do not know about the distributed mode in apache drill's embedded mode
            // the from clause needs to be constructed, like so:
            // storagename.schemaname.collection - when working in MongoDB
            ", b.entered_dt from mongo.`yahoo_finance`.`yahoo_finance` b";

    private DrillConnection connection = null;
    private Statement statement = null;
    private ResultSet resultSet = null;

    public List<QuoteSummary> getQuoteSummariesFromMongoDb() {
        try {
            Driver.load();
            connection = (DrillConnection) DriverManager.getConnection(url);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                QuoteSummary quoteSummary = new QuoteSummary();
                quoteSummary.setTickerSymbol(resultSet.getString(1));
                quoteSummary.setPreviousClosingPrice(resultSet.getDouble(2));
                quoteSummary.setOpeningPrice(resultSet.getDouble(3));
                quoteSummary.setBidOffer(resultSet.getDouble(4));
                quoteSummary.setBidQuantity(resultSet.getInt(5));
                quoteSummary.setAskingPrice(resultSet.getDouble(6));
                quoteSummary.setAskingQuantity(resultSet.getInt(7));
                quoteSummary.setDaysRangeStart(resultSet.getDouble(8));
                quoteSummary.setDaysRangeEnd(resultSet.getDouble(9));
                quoteSummary.setFiftyWeekRangeStart(resultSet.getDouble(10));
                quoteSummary.setFiftyWeekRangeEnd(resultSet.getDouble(11));
                quoteSummary.setVolume(resultSet.getInt(12));
                quoteSummary.setAvgVolume(resultSet.getInt(13));
                quoteSummary.setMarketCap(resultSet.getLong(14));
                quoteSummary.setBeta(resultSet.getDouble(15));
                quoteSummary.setPeRatioTtm(resultSet.getDouble(16));
                quoteSummary.setEpsTtm(resultSet.getDouble(17));
                quoteSummary.setEarningsDateStart(WebScrapeUtils.sqlDateToDateTime(resultSet.getString(18)));
                quoteSummary.setGetEarningsDateEnd(WebScrapeUtils.sqlDateToDateTime(resultSet.getString(19)));
                quoteSummary.setDividend(resultSet.getDouble(20));
                quoteSummary.setYield(resultSet.getDouble(21));
                quoteSummary.setExDividendDate(WebScrapeUtils.sqlDateToDateTime(resultSet.getString(22)));
                quoteSummary.setFirstYearEstimate(resultSet.getDouble(23));
                quoteSummary.setDateEntered(resultSet.getDate(24));
                quoteSummaryList.add(quoteSummary);
            }
        } catch (SQLException e) {
            logger.error("There was an error retrieving the records: \n" + e);
        } finally {
            // Closing the resources
            if (statement != null || connection != null || resultSet != null)
                try {
                    statement.close();
                    connection.close();
                    resultSet.close();
                } catch (SQLException e) {
                    logger.error("There was a problem with closing one of the resources: \n" + e);
                }
        }
        return quoteSummaryList;
    }

    public void printQuoteSummaryObjects(List<QuoteSummary> quoteSummaries) {
        for (QuoteSummary quoteSummary : quoteSummaries) {
            logger.info("QuoteSummary Drilled: " + quoteSummary.toString());
        }
    }
}
