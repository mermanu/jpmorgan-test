/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jpmorgan.ui;

import com.jpmorgan.data.DataStorage;
import com.jpmorgan.factory.JPMorganServices;
import com.jpmorgan.model.Stock;
import com.jpmorgan.portfolio.services.PortfolioService;

import java.util.Map.Entry;
import java.util.Scanner;

/**
 *
 * @author manuelmerida
 */
public class PortfolioUI extends UIScan {

    /**
     *
     * @param reader
     */
    public PortfolioUI(Scanner reader) {
        super(reader);
    }

    /**
     *
     */
    public void newStock() {
        System.out.println("Insert stock symbol:");
        String symbol = reader.nextLine();
        System.out.println("Insert stock type (1:common|2:preferred):");
        String type = reader.nextLine();
        System.out.println("Insert stock last dividend:");
        String lastDividend = reader.nextLine();
        System.out.println("Insert stock par value:");
        String parValue = reader.nextLine();
        System.out.println("Insert stock price:");
        String price = reader.nextLine();
        System.out.println("Insert stock fixed dividend:");
        String fixedDividend = reader.nextLine();
        System.out.println("Insert stock provider:");
        String provider = reader.nextLine();

        PortfolioService portfolioService = (PortfolioService) JPMorganServices.PORTFOLIO_SERVICE.getInstance();
        try {
            portfolioService.newStock(symbol, type, lastDividend, parValue, price, fixedDividend, provider);
        } catch (Exception e) {
            e.printStackTrace();
            newStock();
        }
    }

    /**
     *
     */
    public void updatePortfolio() {
        PortfolioService portfolioService = (PortfolioService) JPMorganServices.PORTFOLIO_SERVICE.getInstance();
        try {
            portfolioService.calculateAllShareIndex();
        } catch (Exception e) {
            e.printStackTrace();
            updatePortfolio();
        }
    }

    /**
     *
     */
    public void report() {
        if (!DataStorage.jpmData.getStocks().isEmpty()) {
            System.out.println("--------------------------------------------------------------");
            for (Entry<String, Stock> entry : DataStorage.jpmData.getStocks().entrySet()) {
                System.out.println("Symbol: " + entry.getKey() + " | price: " + entry.getValue().getPrice()+ " | last dividend: " +entry.getValue().getLastDividend()
                        + " | fixed dividend: " +entry.getValue().getFixedDividend()+ " | par value: " +entry.getValue().getParValue()
                        + " | dividend yield: " +entry.getValue().getCalculated().getDividendYield()+ " | P/E ratio: " +entry.getValue().getCalculated().getPeRatio());   
            }
            System.out.println("--------------------------------------------------------------");
        } else {
            System.out.println("0 registered stocks");
        }
    }
}
