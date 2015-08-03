/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jpmorgan.stock.operations;

import com.jpmorgan.model.Stock;
import com.jpmorgan.common.Constants;

import java.math.BigDecimal;
import java.math.RoundingMode;

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
                break;
            case Constants.PEFERRED_TYPE:
                preferredFormula(stock);
                break;
            default:
                System.out.println("Stock does not provide the type");
                break;
        }
    }
    
    private void commonFormula(Stock stock){
    	BigDecimal dividend=BigDecimal.ZERO;
    	if(stock.getPrice().compareTo(BigDecimal.ZERO)>0){
    		dividend = stock.getLastDividend().divide(stock.getPrice(), Constants.DECIMAL_SCALE, RoundingMode.HALF_UP);
    	}
        stock.getCalculated().setDividendYield(dividend);
    }
    
    private void preferredFormula(Stock stock){
    	BigDecimal dividend=BigDecimal.ZERO;
    	if(stock.getPrice().compareTo(BigDecimal.ZERO)>0){
    		dividend = (stock.getLastDividend().multiply(stock.getParValue())).divide(stock.getPrice(), Constants.DECIMAL_SCALE, RoundingMode.HALF_UP);
    	}
        stock.getCalculated().setDividendYield(dividend);
    }
    
}
