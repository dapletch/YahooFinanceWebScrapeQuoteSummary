package com.yahoofinance.webscrape.beans;

import org.joda.time.DateTime;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Created by Seth on 4/1/2017.
 */
public class QuoteSummary {

    private String tickerSymbol;
    private Double previousClosingPrice;
    private Double openingPrice;
    private Double bidOffer;
    private Integer bidQuantity;
    private Double askingPrice;
    private Integer askingQuantity;
    private Double daysRangeStart;
    private Double daysRangeEnd;
    private Double fiftyWeekRangeStart;
    private Double fiftyWeekRangeEnd;
    private Integer volume;
    private Integer avgVolume;
    private Long marketCap;
    private Double beta;
    private Double peRatioTtm;
    private Double epsTtm;
    private DateTime earningsDateStart;
    private DateTime getEarningsDateEnd;
    private Double dividend;
    private Double yield;
    private DateTime exDividendDate;
    private Double firstYearEstimate;

    public QuoteSummary() {
        super();
    }

    public String getTickerSymbol() {
        return tickerSymbol;
    }

    public void setTickerSymbol(String tickerSymbol) {
        this.tickerSymbol = tickerSymbol;
    }

    public Double getPreviousClosingPrice() {
        return previousClosingPrice;
    }

    public void setPreviousClosingPrice(Double previousClosingPrice) {
        this.previousClosingPrice = previousClosingPrice;
    }

    public Double getOpeningPrice() {
        return openingPrice;
    }

    public void setOpeningPrice(Double openingPrice) {
        this.openingPrice = openingPrice;
    }

    public Double getBidOffer() {
        return bidOffer;
    }

    public void setBidOffer(Double bidOffer) {
        this.bidOffer = bidOffer;
    }

    public Integer getBidQuantity() {
        return bidQuantity;
    }

    public void setBidQuantity(Integer bidQuantity) {
        this.bidQuantity = bidQuantity;
    }

    public Double getAskingPrice() {
        return askingPrice;
    }

    public void setAskingPrice(Double askingPrice) {
        this.askingPrice = askingPrice;
    }

    public Integer getAskingQuantity() {
        return askingQuantity;
    }

    public void setAskingQuantity(Integer askingQuantity) {
        this.askingQuantity = askingQuantity;
    }

    public Double getDaysRangeStart() {
        return daysRangeStart;
    }

    public void setDaysRangeStart(Double daysRangeStart) {
        this.daysRangeStart = daysRangeStart;
    }

    public Double getDaysRangeEnd() {
        return daysRangeEnd;
    }

    public void setDaysRangeEnd(Double daysRangeEnd) {
        this.daysRangeEnd = daysRangeEnd;
    }

    public Double getFiftyWeekRangeStart() {
        return fiftyWeekRangeStart;
    }

    public void setFiftyWeekRangeStart(Double fiftyWeekRangeStart) {
        this.fiftyWeekRangeStart = fiftyWeekRangeStart;
    }

    public Double getFiftyWeekRangeEnd() {
        return fiftyWeekRangeEnd;
    }

    public void setFiftyWeekRangeEnd(Double fiftyWeekRangeEnd) {
        this.fiftyWeekRangeEnd = fiftyWeekRangeEnd;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public Integer getAvgVolume() {
        return avgVolume;
    }

    public void setAvgVolume(Integer avgVolume) {
        this.avgVolume = avgVolume;
    }

    public Long getMarketCap() {
        return marketCap;
    }

    public void setMarketCap(Long marketCap) {
        this.marketCap = marketCap;
    }

    public Double getBeta() {
        return beta;
    }

    public void setBeta(Double beta) {
        this.beta = beta;
    }

    public Double getPeRatioTtm() {
        return peRatioTtm;
    }

    public void setPeRatioTtm(Double peRatioTtm) {
        this.peRatioTtm = peRatioTtm;
    }

    public Double getEpsTtm() {
        return epsTtm;
    }

    public void setEpsTtm(Double epsTtm) {
        this.epsTtm = epsTtm;
    }

    public DateTime getEarningsDateStart() {
        return earningsDateStart;
    }

    public void setEarningsDateStart(DateTime earningsDateStart) {
        this.earningsDateStart = earningsDateStart;
    }

    public DateTime getGetEarningsDateEnd() {
        return getEarningsDateEnd;
    }

    public void setGetEarningsDateEnd(DateTime getEarningsDateEnd) {
        this.getEarningsDateEnd = getEarningsDateEnd;
    }

    public Double getDividend() {
        return dividend;
    }

    public void setDividend(Double dividend) {
        this.dividend = dividend;
    }

    public Double getYield() {
        return yield;
    }

    public void setYield(Double yield) {
        this.yield = yield;
    }

    public DateTime getExDividendDate() {
        return exDividendDate;
    }

    public void setExDividendDate(DateTime exDividendDate) {
        this.exDividendDate = exDividendDate;
    }

    public Double getFirstYearEstimate() {
        return firstYearEstimate;
    }

    public void setFirstYearEstimate(Double firstYearEstimate) {
        this.firstYearEstimate = firstYearEstimate;
    }

    @Override
    public String toString() {
        return "QuoteSummary{" +
                "tickerSymbol='" + tickerSymbol + '\'' +
                ", previousClosingPrice=" + previousClosingPrice +
                ", openingPrice=" + openingPrice +
                ", bidOffer=" + bidOffer +
                ", bidQuantity=" + bidQuantity +
                ", askingPrice=" + askingPrice +
                ", askingQuantity=" + askingQuantity +
                ", daysRangeStart=" + daysRangeStart +
                ", daysRangeEnd=" + daysRangeEnd +
                ", fiftyWeekRangeStart=" + fiftyWeekRangeStart +
                ", fiftyWeekRangeEnd=" + fiftyWeekRangeEnd +
                ", volume=" + volume +
                ", avgVolume=" + avgVolume +
                ", marketCap=" + marketCap +
                ", beta=" + beta +
                ", peRatioTtm=" + peRatioTtm +
                ", epsTtm=" + epsTtm +
                ", earningsDateStart=" + earningsDateStart +
                ", getEarningsDateEnd=" + getEarningsDateEnd +
                ", dividend=" + dividend +
                ", yield=" + yield +
                ", exDividendDate=" + exDividendDate +
                ", firstYearEstimate=" + firstYearEstimate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof QuoteSummary)) return false;

        QuoteSummary that = (QuoteSummary) o;

        if (getTickerSymbol() != null ? !getTickerSymbol().equals(that.getTickerSymbol()) : that.getTickerSymbol() != null)
            return false;
        if (getPreviousClosingPrice() != null ? !getPreviousClosingPrice().equals(that.getPreviousClosingPrice()) : that.getPreviousClosingPrice() != null)
            return false;
        if (getOpeningPrice() != null ? !getOpeningPrice().equals(that.getOpeningPrice()) : that.getOpeningPrice() != null)
            return false;
        if (getBidOffer() != null ? !getBidOffer().equals(that.getBidOffer()) : that.getBidOffer() != null)
            return false;
        if (getBidQuantity() != null ? !getBidQuantity().equals(that.getBidQuantity()) : that.getBidQuantity() != null)
            return false;
        if (getAskingPrice() != null ? !getAskingPrice().equals(that.getAskingPrice()) : that.getAskingPrice() != null)
            return false;
        if (getAskingQuantity() != null ? !getAskingQuantity().equals(that.getAskingQuantity()) : that.getAskingQuantity() != null)
            return false;
        if (getDaysRangeStart() != null ? !getDaysRangeStart().equals(that.getDaysRangeStart()) : that.getDaysRangeStart() != null)
            return false;
        if (getDaysRangeEnd() != null ? !getDaysRangeEnd().equals(that.getDaysRangeEnd()) : that.getDaysRangeEnd() != null)
            return false;
        if (getFiftyWeekRangeStart() != null ? !getFiftyWeekRangeStart().equals(that.getFiftyWeekRangeStart()) : that.getFiftyWeekRangeStart() != null)
            return false;
        if (getFiftyWeekRangeEnd() != null ? !getFiftyWeekRangeEnd().equals(that.getFiftyWeekRangeEnd()) : that.getFiftyWeekRangeEnd() != null)
            return false;
        if (getVolume() != null ? !getVolume().equals(that.getVolume()) : that.getVolume() != null) return false;
        if (getAvgVolume() != null ? !getAvgVolume().equals(that.getAvgVolume()) : that.getAvgVolume() != null)
            return false;
        if (getMarketCap() != null ? !getMarketCap().equals(that.getMarketCap()) : that.getMarketCap() != null)
            return false;
        if (getBeta() != null ? !getBeta().equals(that.getBeta()) : that.getBeta() != null) return false;
        if (getPeRatioTtm() != null ? !getPeRatioTtm().equals(that.getPeRatioTtm()) : that.getPeRatioTtm() != null)
            return false;
        if (getEpsTtm() != null ? !getEpsTtm().equals(that.getEpsTtm()) : that.getEpsTtm() != null) return false;
        if (getEarningsDateStart() != null ? !getEarningsDateStart().equals(that.getEarningsDateStart()) : that.getEarningsDateStart() != null)
            return false;
        if (getGetEarningsDateEnd() != null ? !getGetEarningsDateEnd().equals(that.getGetEarningsDateEnd()) : that.getGetEarningsDateEnd() != null)
            return false;
        if (getDividend() != null ? !getDividend().equals(that.getDividend()) : that.getDividend() != null)
            return false;
        if (getYield() != null ? !getYield().equals(that.getYield()) : that.getYield() != null) return false;
        if (getExDividendDate() != null ? !getExDividendDate().equals(that.getExDividendDate()) : that.getExDividendDate() != null)
            return false;
        return getFirstYearEstimate() != null ? getFirstYearEstimate().equals(that.getFirstYearEstimate()) : that.getFirstYearEstimate() == null;
    }

    @Override
    public int hashCode() {
        int result = getTickerSymbol() != null ? getTickerSymbol().hashCode() : 0;
        result = 31 * result + (getPreviousClosingPrice() != null ? getPreviousClosingPrice().hashCode() : 0);
        result = 31 * result + (getOpeningPrice() != null ? getOpeningPrice().hashCode() : 0);
        result = 31 * result + (getBidOffer() != null ? getBidOffer().hashCode() : 0);
        result = 31 * result + (getBidQuantity() != null ? getBidQuantity().hashCode() : 0);
        result = 31 * result + (getAskingPrice() != null ? getAskingPrice().hashCode() : 0);
        result = 31 * result + (getAskingQuantity() != null ? getAskingQuantity().hashCode() : 0);
        result = 31 * result + (getDaysRangeStart() != null ? getDaysRangeStart().hashCode() : 0);
        result = 31 * result + (getDaysRangeEnd() != null ? getDaysRangeEnd().hashCode() : 0);
        result = 31 * result + (getFiftyWeekRangeStart() != null ? getFiftyWeekRangeStart().hashCode() : 0);
        result = 31 * result + (getFiftyWeekRangeEnd() != null ? getFiftyWeekRangeEnd().hashCode() : 0);
        result = 31 * result + (getVolume() != null ? getVolume().hashCode() : 0);
        result = 31 * result + (getAvgVolume() != null ? getAvgVolume().hashCode() : 0);
        result = 31 * result + (getMarketCap() != null ? getMarketCap().hashCode() : 0);
        result = 31 * result + (getBeta() != null ? getBeta().hashCode() : 0);
        result = 31 * result + (getPeRatioTtm() != null ? getPeRatioTtm().hashCode() : 0);
        result = 31 * result + (getEpsTtm() != null ? getEpsTtm().hashCode() : 0);
        result = 31 * result + (getEarningsDateStart() != null ? getEarningsDateStart().hashCode() : 0);
        result = 31 * result + (getGetEarningsDateEnd() != null ? getGetEarningsDateEnd().hashCode() : 0);
        result = 31 * result + (getDividend() != null ? getDividend().hashCode() : 0);
        result = 31 * result + (getYield() != null ? getYield().hashCode() : 0);
        result = 31 * result + (getExDividendDate() != null ? getExDividendDate().hashCode() : 0);
        result = 31 * result + (getFirstYearEstimate() != null ? getFirstYearEstimate().hashCode() : 0);
        return result;
    }
}