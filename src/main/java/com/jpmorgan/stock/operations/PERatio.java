/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jpmorgan.stock.operations;

import com.jpmorgan.common.Constants;
import com.jpmorgan.model.Stock;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author manuelmerida
 */
public final class PERatio extends StockCalculus {

    /**
     *
     * @param stock
     */
    @Override
    public void execute(Stock stock) {
        BigDecimal dividendYield = (BigDecimal) stock.getCalculated().getDividendYield();
        if (dividendYield.compareTo(BigDecimal.ZERO) > 0) {
            BigDecimal peRatio = stock.getPrice().divide(dividendYield, Constants.DECIMAL_SCALE, RoundingMode.HALF_UP);
            stock.getCalculated().setPeRatio(peRatio);
        }
    }
}
