/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jpmorgan.portfolio.operations;

import com.jpmorgan.common.Constants;
import com.jpmorgan.data.DataStorage;
import com.jpmorgan.model.Stock;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import java.util.Map.Entry;

/**
 *
 * @author manuelmerida
 */
public final class GeometricMean extends PortfolioCalculus {

    /**
     *
     * @param stocks
     */
    @Override
    public void execute(Map<String, Stock> stocks) {
        BigDecimal aPricesMultiplication = BigDecimal.ZERO;
        BigDecimal one = BigDecimal.ONE;
        int i = 0;
        for (Entry<String, Stock> stock : stocks.entrySet()) {
            i++;
            if (i == 1) {
                aPricesMultiplication = stock.getValue().getPrice();
            } else {
                aPricesMultiplication = aPricesMultiplication.multiply(stock.getValue().getPrice());
            }
        }
        if (i > 0) {
            double pow = Math.pow(aPricesMultiplication.doubleValue(), one.divide(new BigDecimal(i), Constants.DECIMAL_SCALE, RoundingMode.HALF_UP).doubleValue());
            DataStorage.jpmData.setAllShareIndex(new BigDecimal(pow));
            System.out.println("GBCE All Share Index updated:" + pow);
        }
    }
}
