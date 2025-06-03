package com.lld.designpatterns.abstractfactory;

public class Phone
{
    String description;
    public Phone(String model)
    {
        this.description = model;
    }
    public void getDescription()
    {
        System.out.println(this.description);
    }
}