/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jpmorgan.factory;

import com.jpmorgan.portfolio.operations.GeometricMean;
import com.jpmorgan.portfolio.operations.PortfolioCalculus;

/**
 *
 * @author manuelmerida
 */
public enum PortfolioOperations {

    /**
     *
     */
    GEOMETRIC_MEAN(new GeometricMean());
    private PortfolioCalculus instance;

    private PortfolioOperations(PortfolioCalculus instance) {
        this.instance = instance;
    }

    /**
     *
     * @return
     */
    public PortfolioCalculus getInstance() {
        return instance;
    }

    /**
     *
     * @param instance
     */
    public void setInstance(PortfolioCalculus instance) {
        this.instance = instance;
    }
}
