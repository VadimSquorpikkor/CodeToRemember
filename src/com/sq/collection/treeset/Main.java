package com.sq.collection.treeset;

import java.lang.reflect.Array;
import java.util.SortedSet;
import java.util.TreeSet;

// Created by SquorpikkoR on 25.12.2016.
public class Main {
    public static void main(String[] args) {
        SortedSet<Person> richManList  = new TreeSet<>();
        int howManyMen = 10;
        for (int i = 0; i < howManyMen; i++) {
            richManList.add(new Person((int) (Math.random()*100), "Vasya"+i));
        }
        for (Person person : richManList) {
            System.out.println(person.getName() + " " + person.getMoneyBalance());
        }

        richManList.last().setMoneyBalance(0);
        

        for (Person person : richManList) {
            System.out.println(person.getName() + " " + person.getMoneyBalance());
        }
    }
}
