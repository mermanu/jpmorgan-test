/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jpmorgan.stock.services;

import com.jpmorgan.data.DataStorage;
import com.jpmorgan.factory.JPMorganServices;
import com.jpmorgan.portfolio.services.PortfolioServiceTest;
import java.math.BigDecimal;
import static junit.framework.Assert.assertEquals;
import junit.framework.TestCase;

/**
 *
 * @author manuelmerida
 */
public class StockServiceTest extends TestCase {
    
    private StockService instance;
    private PortfolioServiceTest portFolioTest;
    
    public StockServiceTest(String testName) {
        super(testName);
        portFolioTest=new PortfolioServiceTest("PortfolioServiceTest");
        instance = (StockService) JPMorganServices.STOCK_SERVICE.getInstance();
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();       
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
    
    public void addTestTrades(String stockKey) throws Exception{
        instance.recordTrade(stockKey, "45", "80", "1", "M");
        instance.recordTrade(stockKey, "20", "110", "1", "M");
        instance.recordTrade(stockKey, "30", "100", "1", "M");
        instance.recordTrade(stockKey, "80", "70", "2", "M");
        instance.recordTrade(stockKey, "12", "120", "1", "M");
        instance.recordTrade(stockKey, "120", "65", "2", "M");
        
    }

    /**
     * Test of recordTrade method, of class StockService.
     */
    public void testRecordTrade() throws Exception {
        portFolioTest.addTeaStock();
        System.out.println("recordTrade");
        String stockKey = "TEA";
        String shares = "45";
        String price = "110";
        String indicator = "1";
        String clientKey = "MANU";
        instance.recordTrade(stockKey, shares, price, indicator, clientKey);
        assertNotNull(DataStorage.jpmData.getStocks().get(stockKey).getTrades());
        assertEquals(1, DataStorage.jpmData.getStocks().get(stockKey).getTrades().size());
        assertEquals(stockKey, DataStorage.jpmData.getStocks().get(stockKey).getTrades().lastEntry().getValue().getStock().getSymbol());
        assertEquals(Integer.parseInt(shares), DataStorage.jpmData.getStocks().get(stockKey).getTrades().lastEntry().getValue().getShares().intValue());
        assertEquals(new BigDecimal(price), DataStorage.jpmData.getStocks().get(stockKey).getTrades().lastEntry().getValue().getPrice());
        assertEquals(Integer.parseInt(indicator), DataStorage.jpmData.getStocks().get(stockKey).getTrades().lastEntry().getValue().getIndicator());
    }

    /**
     * Test of calculateDividendYield method, of class StockService.
     */
    public void testCalculateDividendYield() throws Exception {
        System.out.println("calculateDividendYield");
        String stockKey = "TEA";
        portFolioTest.addTeaStock();
        DataStorage.jpmData.getStocks().get(stockKey).getTrades().clear();
        testRecordTrade();       
        instance.calculateDividendYield(stockKey);
        assertEquals(new BigDecimal("0.00"),DataStorage.jpmData.getStocks().get(stockKey).getCalculated().getDividendYield());
    }

    /**
     * Test of calculatePERadio method, of class StockService.
     */
    public void testCalculatePERadio() throws Exception {
        System.out.println("calculatePERadio");
        String stockKey = "TEA";
        portFolioTest.addTeaStock();
        DataStorage.jpmData.getStocks().get(stockKey).getTrades().clear();
        testRecordTrade();       
        instance.calculatePERadio(stockKey);
        assertEquals(new BigDecimal("0"),DataStorage.jpmData.getStocks().get(stockKey).getCalculated().getPeRatio());
    }

    /**
     * Test of calculateStockPrice method, of class StockService.
     */
    public void testCalculateStockPrice() throws Exception {
        System.out.println("calculateStockPrice");
        portFolioTest.addTeaStock();
        String stockKey = "TEA";
        DataStorage.jpmData.getStocks().get(stockKey).getTrades().clear();
        testRecordTrade();       
        instance.calculateStockPrice(stockKey);
        assertEquals(new BigDecimal("110.00"),DataStorage.jpmData.getStocks().get(stockKey).getCalculated().getStockPrice());
    }
    
    public void testCalculateStockPrice1() throws Exception {
        String stockKey = "TEA";
        DataStorage.jpmData.getStocks().get(stockKey).getTrades().clear();
        addTestTrades(stockKey);
        instance.calculateStockPrice(stockKey);
        //assertEquals(new BigDecimal("65.00"),DataStorage.jpmData.getStocks().get(stockKey).getCalculated().getStockPrice());
    }
}
