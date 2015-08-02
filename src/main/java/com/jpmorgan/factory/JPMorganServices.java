/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jpmorgan.factory;

import com.jpmorgan.portfolio.services.JPMPortfolioService;
import com.jpmorgan.stock.services.JPMStockService;

/**
 *
 * @author manuelmerida
 */
public enum JPMorganServices {
    PORTFOLIO_SERVICE(new JPMPortfolioService()),STOCK_SERVICE(new JPMStockService());
    
    private Object instance;

    private JPMorganServices(Object instance) {
        this.instance = instance;
    }

    public Object getInstance() {
        return instance;
    }

    public void setInstance(Object instance) {
        this.instance = instance;
    }   
}
