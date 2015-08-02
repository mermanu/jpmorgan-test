/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jpmorgan.ui;

import com.jpmorgan.data.DataStorage;
import com.jpmorgan.factory.JPMorganServices;
import com.jpmorgan.stock.services.StockService;
import java.util.Scanner;

/**
 *
 * @author manuelmerida
 */
public class StockUI extends UIScan{

    /**
     *
     * @param reader
     */
    public StockUI(Scanner reader) {
        super(reader);
    }  
    
    /**
     *
     */
    public void newTrade(){
        StockService stockService=(StockService)JPMorganServices.STOCK_SERVICE.getInstance();
        System.out.println("Insert stock symbol:");
        String symbol = reader.nextLine(); 
        System.out.println("Insert shares:");
        String shares = reader.nextLine(); 
        System.out.println("Insert price:");
        String price = reader.nextLine(); 
        System.out.println("Insert indicator:");
        String indicator = reader.nextLine(); 
        System.out.println("Insert client:");
        String client = reader.nextLine();         
        stockService.recordTrade(symbol, shares, price, indicator, client);
    }
    
    /**
     *
     */
    public void updateStockData(){
        StockService stockService=(StockService)JPMorganServices.STOCK_SERVICE.getInstance();
        System.out.println("Insert stock symbol:");
        String symbol = reader.nextLine(); 
        
        stockService.calculateStockPrice(symbol);
        stockService.calculateDividendYield(symbol);
        stockService.calculatePERadio(symbol); 
        System.out.println("Calculated price:"+DataStorage.jpmData.getStocks().get(symbol).getPrice());
        System.out.println("Calculated dividend yield:"+DataStorage.jpmData.getStocks().get(symbol).getCalculated().getDividendYield());
        System.out.println("Calculated pe/ratio:"+DataStorage.jpmData.getStocks().get(symbol).getCalculated().getPeRatio());
        System.out.println("Calculated stock price:"+DataStorage.jpmData.getStocks().get(symbol).getCalculated().getStockPrice());
        
    }
    
}
