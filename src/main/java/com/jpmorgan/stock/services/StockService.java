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
    public void recordTrade(String stockKey, String shares, String price, String indicator, String clientKey) throws Exception;
    /**
     *
     */
    public void calculateDividendYield(String stockKey) throws Exception;
    /**
     *
     */
    public void calculatePERadio(String stockKey) throws Exception;
    /**
     *
     */
    public void calculateStockPrice(String stockKey) throws Exception;
}
