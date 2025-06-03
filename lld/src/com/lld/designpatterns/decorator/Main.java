package com.lld.designpatterns.decorator;

public class Main {
    public static void main(String[] args) {
        //basic pizza
        Pizza pizza = new Margherita();

        //adding decorators
        Pizza pizzaWithToppings = new Toppings(pizza);
        Pizza pizzaWithToppingsAndCheese = new Cheese(pizzaWithToppings);

        String description = pizzaWithToppingsAndCheese.getDescription();
        double price = pizzaWithToppingsAndCheese.getPrice();

        System.out.println("price = " + price);
        System.out.println("description = " + description);

    }
}
