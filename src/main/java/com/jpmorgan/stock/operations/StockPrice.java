/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jpmorgan.stock.operations;

import com.jpmorgan.common.Constants;
import com.jpmorgan.model.Stock;
import com.jpmorgan.model.Trade;
import java.math.BigDecimal;
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
        BigDecimal sumOfPrices = BigDecimal.ZERO;
        BigDecimal sumOfShares = BigDecimal.ZERO;        
        Calendar lastRange = getLastRange();
        
        for(Trade trade : stock.getTrades()){
            if(trade.getTimestamp().after(lastRange)){
                BigDecimal tmpNumShares = new BigDecimal(trade.getShares());
                BigDecimal tmpTrade = trade.getPrice().multiply(tmpNumShares);
                sumOfPrices = sumOfPrices.add(tmpTrade);
                sumOfShares = sumOfShares.add(tmpNumShares);
            }
        }
        BigDecimal price = sumOfPrices.divide(sumOfShares);
        stock.setPrice(price);
        stock.getCalculated().setStockPrice(price);
    }
    
    private Calendar getLastRange(){
        Calendar now = Calendar.getInstance();    
        now.add(Calendar.MINUTE, - Constants.STOCK_CALC_TIME);
        return now;
    }
}
