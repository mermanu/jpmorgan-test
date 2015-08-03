/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jpmorgan.model;

import java.math.BigDecimal;
import java.util.Calendar;

/**
 *
 * @author manuelmerida
 */
public class Trade {

    //number of shares
    private Integer shares;
    private Calendar timestamp;
    //buy sell indicator
    private int indicator;
    private BigDecimal price;
    private Client client;
    private Stock stock;

    /**
     *
     */
    public Trade() {
    }

    /**
     *
     * @return
     */
    public Client getClient() {
        return client;
    }

    /**
     *
     * @param client
     */
    public void setClient(Client client) {
        this.client = client;
    }

    /**
     *
     * @return
     */
    public Integer getShares() {
        return shares;
    }

    /**
     *
     * @param shares
     */
    public void setShares(Integer shares) {
        this.shares = shares;
    }

    /**
     *
     * @return
     */
    public Stock getStock() {
        return stock;
    }

    /**
     *
     * @param stock
     */
    public void setStock(Stock stock) {
        this.stock = stock;
    }

    /**
     *
     * @return
     */
    public Calendar getTimestamp() {
        return timestamp;
    }

    /**
     *
     * @param timestamp
     */
    public void setTimestamp(Calendar timestamp) {
        this.timestamp = timestamp;
    }

    /**
     *
     * @return
     */
    public int getIndicator() {
        return indicator;
    }

    /**
     *
     * @param indicator
     */
    public void setIndicator(int indicator) {
        this.indicator = indicator;
    }

    /**
     *
     * @return
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     *
     * @param price
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
