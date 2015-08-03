/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jpmorgan.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TreeMap;

/**
 *
 * @author manuelmerida
 */
public class Stock {

    private String symbol;
    private TreeMap<Date, Trade> trades;
    private Provider provider;
    private int type;
    private BigDecimal lastDividend;
    private BigDecimal parValue;
    private BigDecimal price;
    private BigDecimal fixedDividend;
    private Calculated calculated;

    /**
     *
     */
    public Stock() {
        this.trades = new TreeMap<Date, Trade>();
        this.calculated = new Calculated();
    }

    /**
     *
     * @return
     */
    public TreeMap<Date, Trade> getTrades() {
        return trades;
    }

    /**
     *
     * @param trades
     */
    public void setTrades(TreeMap<Date, Trade> trades) {
        this.trades = trades;
    }

    /**
     *
     * @return
     */
    public Provider getProvider() {
        return provider;
    }

    /**
     *
     * @param provider
     */
    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    /**
     *
     * @return
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     *
     * @param symbol
     */
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    /**
     *
     * @return
     */
    public int getType() {
        return type;
    }

    /**
     *
     * @param type
     */
    public void setType(int type) {
        this.type = type;
    }

    /**
     *
     * @return
     */
    public BigDecimal getLastDividend() {
        return lastDividend;
    }

    /**
     *
     * @param lastDividend
     */
    public void setLastDividend(BigDecimal lastDividend) {
        this.lastDividend = lastDividend;
    }

    /**
     *
     * @return
     */
    public BigDecimal getParValue() {
        return parValue;
    }

    /**
     *
     * @param parValue
     */
    public void setParValue(BigDecimal parValue) {
        this.parValue = parValue;
    }

    /**
     *
     * @return
     */
    public BigDecimal getFixedDividend() {
        return fixedDividend;
    }

    /**
     *
     * @param fixedDividend
     */
    public void setFixedDividend(BigDecimal fixedDividend) {
        this.fixedDividend = fixedDividend;
    }

    /**
     *
     * @return
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     *
     * @param price
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     *
     * @return
     */
    public Calculated getCalculated() {
        return calculated;
    }

    /**
     *
     * @param calculated
     */
    public void setCalculated(Calculated calculated) {
        this.calculated = calculated;
    }
}
