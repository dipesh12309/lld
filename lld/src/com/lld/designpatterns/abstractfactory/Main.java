package com.lld.designpatterns.abstractfactory;

public class Main {
    public static void main(String[] args) {
        Phone phone = PhoneStore.getPhone("Apple","iphone14 pro");
        System.out.println(phone.description);
    }
}
