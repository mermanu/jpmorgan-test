/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jpmorgan.portfolio.operations;

import com.jpmorgan.common.Operation;
import com.jpmorgan.model.Stock;
import java.util.Map;

/**
 *
 * @author manuelmerida
 */
public abstract class PortfolioCalculus extends Operation {

    /**
     *
     * @param stocks
     */
    public abstract void execute(Map<String, Stock> stocks);
}
