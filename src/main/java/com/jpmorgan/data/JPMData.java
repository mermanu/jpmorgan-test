/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jpmorgan.data;

import com.jpmorgan.common.Constants;
import com.jpmorgan.model.Client;
import com.jpmorgan.model.Provider;
import com.jpmorgan.model.Stock;
import com.jpmorgan.model.Trade;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author manuelmerida
 */
public class JPMData {

    private Map<String, Stock> stocks;
    private List<Stock> stockHistory;
    private List<Trade> tradesHistory;
    private Map<String, Client> clients;
    private Map<String, Provider> providers;
    private BigDecimal allShareIndex;
    private int stockUpdateTime;

    /**
     *
     */
    public JPMData() {
        this.stocks = new HashMap<String, Stock>();
        this.clients = new HashMap<String, Client>();
        this.providers = new HashMap<String, Provider>();
        this.tradesHistory = new ArrayList<Trade>();
        this.stockHistory = new ArrayList<Stock>();
        this.allShareIndex = new BigDecimal(BigInteger.ZERO);
        this.stockUpdateTime = Constants.STOCK_CALC_TIME;
    }

    /**
     *
     * @return
     */
    public Map<String, Stock> getStocks() {
        return stocks;
    }

    /**
     *
     * @param stocks
     */
    public void setStocks(Map<String, Stock> stocks) {
        this.stocks = stocks;
    }

    /**
     *
     * @return
     */
    public Map<String, Client> getClients() {
        return clients;
    }

    /**
     *
     * @param clients
     */
    public void setClients(Map<String, Client> clients) {
        this.clients = clients;
    }

    /**
     *
     * @return
     */
    public Map<String, Provider> getProviders() {
        return providers;
    }

    /**
     *
     * @param providers
     */
    public void setProviders(Map<String, Provider> providers) {
        this.providers = providers;
    }

    /**
     *
     * @return
     */
    public List<Stock> getStockHistory() {
        return stockHistory;
    }

    /**
     *
     * @param stockHistory
     */
    public void setStockHistory(List<Stock> stockHistory) {
        this.stockHistory = stockHistory;
    }

    /**
     *
     * @return
     */
    public List<Trade> getTradesHistory() {
        return tradesHistory;
    }

    /**
     *
     * @param tradesHistory
     */
    public void setTradesHistory(List<Trade> tradesHistory) {
        this.tradesHistory = tradesHistory;
    }

    /**
     *
     * @return
     */
    public BigDecimal getAllShareIndex() {
        return allShareIndex;
    }

    /**
     *
     * @param allShareIndex
     */
    public void setAllShareIndex(BigDecimal allShareIndex) {
        this.allShareIndex = allShareIndex;
    }

    /**
     *
     * @return
     */
    public int getStockUpdateTime() {
        return stockUpdateTime;
    }

    /**
     *
     * @param stockUpdateTime
     */
    public void setStockUpdateTime(int stockUpdateTime) {
        this.stockUpdateTime = stockUpdateTime;
    }
}
