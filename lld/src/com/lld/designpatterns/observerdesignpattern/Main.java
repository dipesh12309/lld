package com.lld.designpatterns.observerdesignpattern;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Investor investor1 = new Investor_A();
        Investor investor2 = new Investor_A();
        Investor investor3 = new Investor_B();
        Investor investor4 = new Investor_B();
        StockInterface stock = new Stock("mrf",200d);

        stock.register(investor1);
        stock.register(investor2);
        stock.register(investor3);
        stock.register(investor4);

        StockUpdater stockUpdater = new StockUpdater(stock);
        Thread thread = new Thread(stockUpdater);
        thread.start();
        thread.join();
    }
}
