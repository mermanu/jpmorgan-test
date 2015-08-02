/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jpmorgan.portfolio.services;

import com.jpmorgan.data.DataStorage;
import com.jpmorgan.model.Provider;
import com.jpmorgan.model.Stock;
import java.math.BigDecimal;

/**
 *
 * @author manuelmerida
 */
public class JPMPortfolioService implements PortfolioService{

    public void newStock(String symbol, String type, String lastDividend, String parValue, String price, String fixedDividend, String provider) {
        Stock stock=new Stock();
        stock.setSymbol(symbol);    
        stock.setType(Integer.parseInt(type));
        stock.setLastDividend(new BigDecimal(lastDividend));
        stock.setParValue(new BigDecimal(parValue));
        stock.setPrice(new BigDecimal(price));
        stock.setFixedDividend(new Float(fixedDividend));
        if(DataStorage.jpmData.getProviders().get(provider)==null){
            Provider prov=new Provider();
            prov.setName(provider);
            DataStorage.jpmData.getProviders().put(provider, prov);            
        }
        stock.setProvider(DataStorage.jpmData.getProviders().get(provider));        
        DataStorage.jpmData.getStocks().put(stock.getSymbol(), stock);   
    }    
}
