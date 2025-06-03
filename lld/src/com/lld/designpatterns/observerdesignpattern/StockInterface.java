package com.lld.designpatterns.observerdesignpattern;

public interface StockInterface {
    public void register(Investor investor);
    public void unregister(Investor investor);
    public void notifyChange();
    public void setPrice(double price);
    public double getPrice();
}