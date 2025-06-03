package com.lld.designpatterns.strategypattern;

public class Main {
    public static void main(String[] args) {
        Vehicle luxuryCar = new LuxuryVechile(new LuxuryDrive());
        luxuryCar.drive();
    }
}
