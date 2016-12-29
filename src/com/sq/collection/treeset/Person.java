package com.sq.collection.treeset;

// Created by SquorpikkoR on 25.12.2016.

public class Person implements Comparable<Person>{

    private int moneyBalance;
    private String name;

    //region GETTER & SETTERS
    public int getMoneyBalance() {
        return moneyBalance;
    }

    public void setMoneyBalance(int moneyBalance) {
        this.moneyBalance = moneyBalance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    //endregion


    public Person(int moneyBalance, String name) {
        this.moneyBalance = moneyBalance;
        this.name = name;
    }

    @Override
    public int compareTo(Person o) {
        return Integer.compare(moneyBalance, o.moneyBalance);
    }
}
