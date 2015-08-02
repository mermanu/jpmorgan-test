/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jpmorgan.stock.operations;

import com.jpmorgan.common.Operation;
import com.jpmorgan.model.Stock;

/**
 *
 * @author manuelmerida
 */
public abstract class StockCalculus extends Operation{
    
    /**
     *
     * @param stock
     */
    public abstract void execute(Stock stock);
    
}
