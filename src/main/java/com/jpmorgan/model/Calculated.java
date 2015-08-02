/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jpmorgan.model;

/**
 *
 * @author manuelmerida
 */
public class Calculated {
    /**
     *
     */
    protected Number dividendYield;
    
    /**
     *
     */
    protected Number peRatio;
    
    /**
     *
     */
    protected Number stockPrice;

    /**
     *
     * @return
     */
    public Number getDividendYield() {
        return dividendYield;
    }

    /**
     *
     * @param dividendYield
     */
    public void setDividendYield(Number dividendYield) {
        this.dividendYield = dividendYield;
    }

    /**
     *
     * @return
     */
    public Number getPeRatio() {
        return peRatio;
    }

    /**
     *
     * @param peRatio
     */
    public void setPeRatio(Number peRatio) {
        this.peRatio = peRatio;
    }

    /**
     *
     * @return
     */
    public Number getStockPrice() {
        return stockPrice;
    }

    /**
     *
     * @param stockPrice
     */
    public void setStockPrice(Number stockPrice) {
        this.stockPrice = stockPrice;
    }   
}
