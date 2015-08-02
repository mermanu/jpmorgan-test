/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jpmorgan.ui;

import com.jpmorgan.portfolio.services.JPMPortfolioService;
import com.jpmorgan.portfolio.services.PortfolioService;
import java.util.Scanner;


/**
 *
 * @author manuelmerida
 */
public class PortfolioUI extends UIScan{

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
    public void newStock(){
        System.out.println("Insert stock symbol:");
        String symbol = reader.nextLine(); 
        System.out.println("Insert stock type:");
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
        
        PortfolioService portfolioService=new JPMPortfolioService();
        portfolioService.newStock(symbol, type, lastDividend, parValue, price, fixedDividend, provider);
    }
    
    /**
     *
     */
    public void updatePortfolio(){
        
    }
}
