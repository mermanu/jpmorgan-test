/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jpmorgan.model;

import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author manuelmerida
 */
public class Stock {
    
    private String symbol;
    
    private List<Trade> trades;
            
    private Provider provider;
    
    private int type;
    
    private BigDecimal lastDividend;
    
    private BigDecimal parValue;
    
    private BigDecimal price;
    
    private float fixedDividend;
    
    private Calculated calculated;

    /**
     *
     */
    public Stock() {
    }    

    /**
     *
     * @return
     */
    public List<Trade> getTrades() {
        return trades;
    }

    /**
     *
     * @param trades
     */
    public void setTrades(List<Trade> trades) {
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
    public float getFixedDividend() {
        return fixedDividend;
    }

    /**
     *
     * @param fixedDividend
     */
    public void setFixedDividend(float fixedDividend) {
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
