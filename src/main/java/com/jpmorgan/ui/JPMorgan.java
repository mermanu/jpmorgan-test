package com.jpmorgan.ui;

import com.jpmorgan.data.DataStorage;
import com.jpmorgan.data.JPMData;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class JPMorgan {

    private static final String EXIT = "exit";
    private static Integer option = 0;

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("J&P Morgan portfolio:");

        DataStorage.jpmData = new JPMData();

        Scanner reader = new Scanner(System.in);
        String scanned = reader.nextLine();

        StockUI stockUi = new StockUI(reader);
        PortfolioUI portfolioUi = new PortfolioUI(reader);

        while (!scanned.equals(EXIT)) {
            showMenu(scanned, reader);

            switch (option) {
                case 1:
                    portfolioUi.newStock();
                    break;
                case 2:
                    stockUi.newTrade();
                    break;
                case 3:
                    stockUi.updateStockData();
                    break;
                case 4:
                    portfolioUi.updatePortfolio();
                    break;
                case 5:
                    stockUi.report();
                    ;
                    break;
                case 6:
                    portfolioUi.report();
                    break;
                default:
                    System.out.println("Insert a valid option");
                    break;
            }
        }

    }

    /**
     *
     * @param scanned
     * @param reader
     */
    public static void showMenu(String scanned, Scanner reader) {
        System.out.println("\n");
        System.out.println("-----------------------------------");
        System.out.println("Please select an option");
        System.out.println("1. New Stock");
        System.out.println("2. New trade");
        System.out.println("3. Update Stock data");
        System.out.println("4. Update portfolio data");
        System.out.println("5. Stock report");
        System.out.println("6. Portfolio report");
        scanned = reader.nextLine();

        option = 0;
        try {
            option = Integer.valueOf(scanned);
        } catch (Exception e) {
            System.out.println("Please insert a number");
        }
    }
}
