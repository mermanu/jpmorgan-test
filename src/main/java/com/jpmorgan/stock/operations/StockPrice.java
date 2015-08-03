/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jpmorgan.stock.operations;

import com.jpmorgan.common.Constants;
import com.jpmorgan.model.Stock;
import com.jpmorgan.model.Trade;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Calendar;

/**
 *
 * @author manuelmerida
 */
public final class StockPrice extends StockCalculus{

    /**
     *
     * @param stock
     */
    @Override
    public void execute(Stock stock) {        
        BigDecimal sumOfShares = BigDecimal.ZERO;
        BigDecimal price = BigDecimal.ZERO;
        Calendar lastRange = getLastRange();
        boolean newPrice = false;
        
        for(Trade trade : stock.getTrades()){
            if(trade.getTimestamp().after(lastRange)){            	
            	newPrice=true;	
                BigDecimal tmpNumShares = new BigDecimal(trade.getShares());
                BigDecimal tmpTrade = trade.getPrice().multiply(tmpNumShares);                
                sumOfShares = sumOfShares.add(tmpNumShares);
                BigDecimal tmpPrice = tmpTrade.divide(sumOfShares, Constants.DECIMAL_SCALE, RoundingMode.HALF_UP);
                price = price.add(tmpPrice);
            }
        }
         
        if(newPrice){
        	System.out.println("Stock price is updated -- "+price);
        	stock.setPrice(price);
        	stock.getCalculated().setStockPrice(price);        	
        }
    }
    
    private Calendar getLastRange(){
        Calendar now = Calendar.getInstance();    
        now.add(Calendar.MINUTE, - Constants.STOCK_CALC_TIME);
        return now;
    }
}
