package com.lld.designpatterns.observerdesignpattern;

import java.util.Random;

public class StockUpdater implements Runnable{
    StockInterface stock;
    public StockUpdater(StockInterface stock){
        this.stock = stock;
    }
    @Override
    public void run() {
        Random random = new Random();
        while (true){
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            double change = (random.nextDouble() * 10) - 5;
            double newPrice = stock.getPrice() + change;
            stock.setPrice(newPrice);
            stock.notifyChange();
        }
    }
}
