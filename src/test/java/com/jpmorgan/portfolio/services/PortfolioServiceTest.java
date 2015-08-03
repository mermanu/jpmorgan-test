/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jpmorgan.portfolio.services;

import com.jpmorgan.common.Constants;
import com.jpmorgan.data.DataStorage;
import com.jpmorgan.factory.JPMorganServices;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import junit.framework.TestCase;

/**
 *
 * @author manuelmerida
 */
public class PortfolioServiceTest extends TestCase {
    
    private PortfolioService instance;
    
    public PortfolioServiceTest(String testName) {
        super(testName);
        instance= (PortfolioService) JPMorganServices.PORTFOLIO_SERVICE.getInstance();
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
    
    public void addTeaStock() throws Exception{
        String symbol = "TEA";
        String type = "1";
        String lastDividend = "0";
        String parValue = "100";
        String price = "110";
        String fixedDividend = "0";
        String provider = "M";
        instance.newStock(symbol, type, lastDividend, parValue, price, fixedDividend, provider);  
    }
    
    public void addPopStock() throws Exception{
        String symbol = "POP";
        String type = "1";
        String lastDividend = "8";
        String parValue = "100";
        String price = "115";
        String fixedDividend = "0";
        String provider = "M";
        instance.newStock(symbol, type, lastDividend, parValue, price, fixedDividend, provider);  
    }
    
    public void addAleStock() throws Exception{
        String symbol = "ALE";
        String type = "1";
        String lastDividend = "23";
        String parValue = "60";
        String price = "90";
        String fixedDividend = "0";
        String provider = "M";
        instance.newStock(symbol, type, lastDividend, parValue, price, fixedDividend, provider);  
    }
    
    public void addGinStock() throws Exception{
        String symbol = "GIN";
        String type = "2";
        String lastDividend = "8";
        String parValue = "100";
        String price = "80";
        String fixedDividend = "2";
        String provider = "M";
        instance.newStock(symbol, type, lastDividend, parValue, price, fixedDividend, provider);  
    }
    
    public void addJoeStock() throws Exception{
        String symbol = "JOE";
        String type = "1";
        String lastDividend = "13";
        String parValue = "250";
        String price = "300";
        String fixedDividend = "0";
        String provider = "M";
        instance.newStock(symbol, type, lastDividend, parValue, price, fixedDividend, provider);  
    }
    
    public void addAllStocks() throws Exception{
        addAleStock();
        addGinStock();
        addJoeStock();
        addPopStock();
        addTeaStock();
    }

    /**
     * Test of newStock method, of class PortfolioService.
     */
    public void testNewStockBasic() throws Exception {
        System.out.println("newStock");
        String symbol = "TEA";
        String type = "1";
        String lastDividend = "0";
        String parValue = "100";
        String price = "110";
        String fixedDividend = "0";
        String provider = "M";
        instance.newStock(symbol, type, lastDividend, parValue, price, fixedDividend, provider);       
        assertNotNull(DataStorage.jpmData.getStocks().get(symbol));
        assertEquals(provider, DataStorage.jpmData.getStocks().get(symbol).getProvider().getName());
        assertEquals(new BigDecimal(lastDividend), DataStorage.jpmData.getStocks().get(symbol).getLastDividend());
        assertEquals(new BigDecimal(parValue), DataStorage.jpmData.getStocks().get(symbol).getParValue());
        assertEquals(new BigDecimal(price), DataStorage.jpmData.getStocks().get(symbol).getPrice());
        assertEquals(new BigDecimal(fixedDividend), DataStorage.jpmData.getStocks().get(symbol).getFixedDividend());
        assertEquals(Integer.parseInt(type), DataStorage.jpmData.getStocks().get(symbol).getType());
        
    }

    /**
     * Test of updateStockData method, of class PortfolioService.
     */
    public void testUpdateStockDataBasic() throws Exception {
        System.out.println("updateStockData");
        addTeaStock();
        String symbol = "TEA";
        instance.updateStockData(symbol);
        assertEquals(new BigDecimal("110"),DataStorage.jpmData.getStocks().get(symbol).getPrice());
        assertEquals(new BigDecimal("0.00"),DataStorage.jpmData.getStocks().get(symbol).getCalculated().getDividendYield());
        assertEquals(new BigDecimal("0"),DataStorage.jpmData.getStocks().get(symbol).getCalculated().getPeRatio());
        assertEquals(new BigDecimal("0"),DataStorage.jpmData.getStocks().get(symbol).getCalculated().getStockPrice());
        
    }

    /**
     * Test of calculateAllShareIndex method, of class PortfolioService.
     */
    public void testCalculateAllShareIndexBasic() throws Exception {
        System.out.println("calculateAllShareIndex");
        addAllStocks();
        instance.calculateAllShareIndex();
        assertEquals(new BigDecimal("122.27"),DataStorage.jpmData.getAllShareIndex().divide(new BigDecimal(BigInteger.ONE), Constants.DECIMAL_SCALE, RoundingMode.HALF_UP));
    }

    /**
     * Test of configuration method, of class PortfolioService.
     */
    public void testConfigurationBasic() throws Exception {
        System.out.println("configuration");
        String minutes = "15";
        instance.configuration(minutes);
        assertNotNull(DataStorage.jpmData.getStockUpdateTime());
        assertEquals(Integer.parseInt(minutes), DataStorage.jpmData.getStockUpdateTime());
    }
    
    public void testAddAllStocks() throws Exception{
        addAllStocks();
        assertEquals(5,DataStorage.jpmData.getStocks().size());
    }
}
