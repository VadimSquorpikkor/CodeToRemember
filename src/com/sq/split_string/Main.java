package com.sq.split_string;

 // Created by SquorpikkoR on 22.12.2016.

public class Main {
    public static void main(String[] args) {

        Split sp = new Split();
        sp.displayStringArray(sp.splitTheString("Vadim-Squorpikkor", "-"));
    }
}
/*public class Test {     //вариант из инета

    public static void main(String args[]) {
        String Str = new String("Разделяем эту строку на слова");

        for (String retval : Str.split(" ")) {
            System.out.println(retval);
        }
    }
}*/
