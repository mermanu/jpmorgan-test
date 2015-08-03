/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jpmorgan.stock.services;

import com.jpmorgan.data.DataStorage;
import com.jpmorgan.factory.StockOperations;
import com.jpmorgan.model.Client;
import com.jpmorgan.model.Stock;
import com.jpmorgan.model.Trade;
import java.math.BigDecimal;
import java.util.Calendar;

/**
 *
 * @author manuelmerida
 */
public class JPMStockService implements StockService {

    public void calculateDividendYield(String stockKey) throws Exception {
        StockOperations.DIVIDEND_YIELD.getInstance().execute(DataStorage.jpmData.getStocks().get(stockKey));
    }

    public void calculatePERadio(String stockKey) throws Exception {
        StockOperations.PERATIO.getInstance().execute(DataStorage.jpmData.getStocks().get(stockKey));
    }

    public void calculateStockPrice(String stockKey) throws Exception {
        StockOperations.STOCKPRICE.getInstance().execute(DataStorage.jpmData.getStocks().get(stockKey));
    }

    public void recordTrade(String stockKey, String shares, String price, String indicator, String clientKey) throws Exception {
        Stock stock = DataStorage.jpmData.getStocks().get(stockKey);
        Trade trade = new Trade();
        Integer sharesNumber = Integer.parseInt(shares);

        if (DataStorage.jpmData.getClients().get(clientKey) == null) {
            Client client = new Client();
            client.setName(clientKey);
            DataStorage.jpmData.getClients().put(clientKey, client);
        }
        trade.setClient(DataStorage.jpmData.getClients().get(clientKey));
        trade.setIndicator(Integer.parseInt(indicator));
        trade.setPrice(new BigDecimal(price));
        trade.setShares(sharesNumber);
        trade.setStock(stock);
        trade.setTimestamp(Calendar.getInstance());
        stock.getTrades().add(trade);
    }
}
