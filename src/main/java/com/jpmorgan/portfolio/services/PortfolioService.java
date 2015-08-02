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
    
    public void newStock(String symbol, String type, String lastDividend, String parValue, String price, String fixedDividend, String provider);
    
}
