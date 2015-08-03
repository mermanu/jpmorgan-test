/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jpmorgan.portfolio.services;

import com.jpmorgan.data.DataStorage;
import com.jpmorgan.factory.JPMorganServices;
import com.jpmorgan.factory.PortfolioOperations;
import com.jpmorgan.model.Provider;
import com.jpmorgan.model.Stock;
import com.jpmorgan.stock.services.StockService;

import java.math.BigDecimal;

/**
 *
 * @author manuelmerida
 */
public class JPMPortfolioService implements PortfolioService {

    /**
     *
     * @param symbol
     * @param type
     * @param lastDividend
     * @param parValue
     * @param price
     * @param fixedDividend
     * @param provider
     * @throws Exception
     */
    public void newStock(String symbol, String type, String lastDividend, String parValue, String price, String fixedDividend, String provider) throws Exception {
        Stock stock = new Stock();
        stock.setSymbol(symbol);
        stock.setType(Integer.parseInt(type));
        stock.setLastDividend(new BigDecimal(lastDividend));
        stock.setParValue(new BigDecimal(parValue));
        stock.setPrice(new BigDecimal(price));
        stock.setFixedDividend(new BigDecimal(fixedDividend));
        if (DataStorage.jpmData.getProviders().get(provider) == null) {
            Provider prov = new Provider();
            prov.setName(provider);
            DataStorage.jpmData.getProviders().put(provider, prov);
        }
        stock.setProvider(DataStorage.jpmData.getProviders().get(provider));
        DataStorage.jpmData.getStocks().put(stock.getSymbol(), stock);
    }

    /**
     *
     * @param symbol
     * @throws Exception
     */
    public void updateStockData(String symbol) throws Exception {
        StockService stockService = (StockService) JPMorganServices.STOCK_SERVICE.getInstance();
        stockService.calculateStockPrice(symbol);
        stockService.calculateDividendYield(symbol);
        stockService.calculatePERadio(symbol);
        System.out.println("Calculated price:" + DataStorage.jpmData.getStocks().get(symbol).getPrice());
        System.out.println("Calculated dividend yield:" + DataStorage.jpmData.getStocks().get(symbol).getCalculated().getDividendYield());
        System.out.println("Calculated pe/ratio:" + DataStorage.jpmData.getStocks().get(symbol).getCalculated().getPeRatio());
        System.out.println("Calculated stock price:" + DataStorage.jpmData.getStocks().get(symbol).getCalculated().getStockPrice());
    }

    /**
     *
     * @throws Exception
     */
    public void calculateAllShareIndex() throws Exception {
        PortfolioOperations.GEOMETRIC_MEAN.getInstance().execute(DataStorage.jpmData.getStocks());
    }
}
