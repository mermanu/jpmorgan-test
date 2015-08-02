package com.jpmorgan.ui;

import com.jpmorgan.data.DataStorage;
import com.jpmorgan.data.JPMData;
import java.util.Scanner;


/**
 * Hello world!
 *
 */
public class JPMorgan 
{
    private static final String EXIT = "exit";
    /**
     *
     * @param args
     */
    public static void main( String[] args )
    {
        System.out.println( "J&P Morgan portfolio:" );
        
        DataStorage.jpmData = new JPMData();
        
        Scanner reader = new Scanner(System.in);
        String scanned = reader.nextLine();       
        
        StockUI stockUi=new StockUI(reader);
        PortfolioUI portfolioUi = new PortfolioUI(reader);
        
        while(!scanned.equals(EXIT)){
            System.out.println("Please select an option");
            System.out.println("1. New Stock");
            System.out.println("2. New trade");            
            System.out.println("3. Update Stock data");
            System.out.println("4. Update portfolio data");
            scanned = reader.nextLine(); 
            
            int option = 0;
            try{
                option = Integer.valueOf(scanned);
            }catch(Exception e){
                System.out.println("Please insert a number");
            }
            
            switch(option){
                case 1:  
                    portfolioUi.newStock();
                case 2:
                    stockUi.newTrade();
                case 3:
                    stockUi.updateStockData();
                case 4:
                    portfolioUi.updatePortfolio();
                default :
                    System.out.println("Insert a valid option");
            }
            
        }
        
    }
}
