package com.sq.split_string;

 // Created by SquorpikkoR on 22.12.2016.

public class Split {
    String[] splitTheString(String string, String regular) {
        String result[] = string.split(regular);//можно конечно и по-короче, без новой
        return result;                          //переменной, но так код понятней
    }

    void displayStringArray(String[] strArray) {
        for (String string : strArray) {
            System.out.println(string);
        }
    }
}
