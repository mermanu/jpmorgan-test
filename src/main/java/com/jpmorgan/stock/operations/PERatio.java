/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jpmorgan.stock.operations;

import com.jpmorgan.model.Stock;
import java.math.BigDecimal;

/**
 *
 * @author manuelmerida
 */
public final class PERatio extends StockCalculus{

    /**
     *
     * @param stock
     */
    @Override
    public void execute(Stock stock) {
        BigDecimal peRatio = stock.getPrice().divide((BigDecimal)stock.getCalculated().getDividendYield());
        stock.getCalculated().setPeRatio(peRatio);
    }
    
}
