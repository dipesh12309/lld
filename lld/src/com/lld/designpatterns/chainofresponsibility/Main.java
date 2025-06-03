package com.lld.designpatterns.chainofresponsibility;

public class Main {
    public static void main(String[] args) {
        RequestHandler manager = new Manager();
        RequestHandler seniorManager = new SeniorManager();
        RequestHandler director = new Director();

        manager.setNext(seniorManager);
        seniorManager.setNext(director);
        director.setNext(null);

        manager.approve(100);
        manager.approve(1);
        manager.approve(3038);
    }
}
