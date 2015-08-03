/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jpmorgan.ui;

import com.jpmorgan.data.DataStorage;
import com.jpmorgan.factory.JPMorganServices;
import com.jpmorgan.model.Trade;
import com.jpmorgan.portfolio.services.PortfolioService;
import com.jpmorgan.stock.services.StockService;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 *
 * @author manuelmerida
 */
public class StockUI extends UIScan {

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
    public void newTrade() {
        StockService stockService = (StockService) JPMorganServices.STOCK_SERVICE.getInstance();
        System.out.println("Insert stock symbol:");
        String symbol = reader.nextLine();
        if (DataStorage.jpmData.getStocks().get(symbol) != null) {
            System.out.println("Insert shares:");
            String shares = reader.nextLine();
            System.out.println("Insert price:");
            String price = reader.nextLine();
            System.out.println("Insert indicator (1=buy|2=sell):");
            String indicator = reader.nextLine();
            System.out.println("Insert client:");
            String client = reader.nextLine();
            try{
                stockService.recordTrade(symbol, shares, price, indicator, client);
             }catch(Exception e){
                e.printStackTrace();
                newTrade();
            }
            
        } else {
            System.out.println("invalid stock symbol");
            newTrade();
        }
    }

    /**
     *
     */
    public void updateStockData() {
        System.out.println("Insert stock symbol:");
        String symbol = reader.nextLine();
        if (DataStorage.jpmData.getStocks().get(symbol) != null) {
            PortfolioService portfolioService = (PortfolioService) JPMorganServices.PORTFOLIO_SERVICE.getInstance();
            try{
                portfolioService.updateStockData(symbol);
            }catch(Exception e){
                e.printStackTrace();
                updateStockData();
            }
        } else {
            System.out.println("invalid stock symbol");
            updateStockData();
        }
    }

    public void report() {
        System.out.println("Insert stock symbol:");
        String symbol = reader.nextLine();
        if (DataStorage.jpmData.getStocks().get(symbol) != null) {
            if (!DataStorage.jpmData.getStocks().get(symbol).getTrades().isEmpty()) {
                SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                int i = 0;
                System.out.println("--------------------------------------------------------------");
                for (Trade trade : DataStorage.jpmData.getStocks().get(symbol).getTrades()) {
                    System.out.println(i++ + "- time: " + format1.format(trade.getTimestamp().getTime()) + " | shares:" + trade.getShares() + " | price:" + trade.getPrice() + " | client:" + trade.getClient().getName());
                }
                System.out.println("--------------------------------------------------------------");
            } else {
                System.out.println("Stock does not have any registered transaction");
            }
        } else {
            System.out.println("invalid stock symbol");
            report();
        }
    }
}
