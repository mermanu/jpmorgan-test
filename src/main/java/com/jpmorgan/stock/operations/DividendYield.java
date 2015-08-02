/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jpmorgan.stock.operations;

import com.jpmorgan.model.Stock;
import com.jpmorgan.common.Constants;
import java.math.BigDecimal;

/**
 *
 * @author manuelmerida
 */
public final class DividendYield extends StockCalculus{

    /**
     *
     * @param stock
     */
    @Override
    public void execute(Stock stock) {
        switch(stock.getType()){
            case Constants.COMMON_TYPE:
                commonFormula(stock);
            case Constants.PEFERRED_TYPE:
                preferredFormula(stock);
            default:
                System.out.println("Stock does not provide the type");
        }
    }
    
    private void commonFormula(Stock stock){
        BigDecimal dividend = stock.getLastDividend().divide(stock.getPrice());
        stock.getCalculated().setDividendYield(dividend);
    }
    
    private void preferredFormula(Stock stock){
        BigDecimal dividend = (stock.getLastDividend().multiply(stock.getParValue())).divide(stock.getPrice());
        stock.getCalculated().setDividendYield(dividend);
    }
    
}
