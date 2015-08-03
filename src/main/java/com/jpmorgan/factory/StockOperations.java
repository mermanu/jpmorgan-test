/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jpmorgan.factory;

import com.jpmorgan.stock.operations.DividendYield;
import com.jpmorgan.stock.operations.PERatio;
import com.jpmorgan.stock.operations.StockCalculus;
import com.jpmorgan.stock.operations.StockPrice;

/**
 *
 * @author manuelmerida
 */
public enum StockOperations {

    /**
     *
     */
    DIVIDEND_YIELD(new DividendYield()),
    /**
     *
     */
    PERATIO(new PERatio()),
    /**
     *
     */
    STOCKPRICE(new StockPrice());
    private StockCalculus instance;

    private StockOperations(StockCalculus instance) {
        this.instance = instance;
    }

    /**
     *
     * @return
     */
    public StockCalculus getInstance() {
        return instance;
    }

    /**
     *
     * @param instance
     */
    public void setInstance(StockCalculus instance) {
        this.instance = instance;
    }
}
