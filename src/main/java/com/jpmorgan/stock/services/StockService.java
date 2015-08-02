/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jpmorgan.stock.services;

/**
 *
 * @author manuelmerida
 */
public interface StockService {    
    /**
     *
     */
    public void recordTrade();
    /**
     *
     */
    public void calculateDividendYield();
    /**
     *
     */
    public void calculatePERadio();
    /**
     *
     */
    public void calculateStockPrice();
}
