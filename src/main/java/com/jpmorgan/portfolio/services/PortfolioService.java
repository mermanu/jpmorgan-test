/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jpmorgan.portfolio.services;

/**
 *
 * @author manuelmerida
 */
public interface PortfolioService {

    /**
     *
     * @param symbol
     * @param type
     * @param lastDividend
     * @param parValue
     * @param price
     * @param fixedDividend
     * @param provider
     * @throws Exception
     */
    public void newStock(String symbol, String type, String lastDividend, String parValue, String price, String fixedDividend, String provider) throws Exception;

    /**
     *
     * @param symbol
     * @throws Exception
     */
    public void updateStockData(String symbol) throws Exception;

    /**
     *
     * @throws Exception
     */
    public void calculateAllShareIndex() throws Exception;

    /**
     *
     * @param minutes
     * @throws Exception
     */
    public void configuration(String minutes) throws Exception;
}
