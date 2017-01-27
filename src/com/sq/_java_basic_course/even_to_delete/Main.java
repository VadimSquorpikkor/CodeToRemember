package com.sq._java_basic_course.even_to_delete; // Created by SquorpikkoR on 26.01.2017.

//////////////////////ПОЧЕМУ???????????ПРОШЛО ПРОВЕРКУ НА СТЕПИКЕ??????????????????

/*
Напишите программу, которая прочитает из System.in последовательность целых чисел,
разделенных пробелами, затем удалит из них все числа, стоящие на четных позициях,
и затем выведет получившуюся последовательность в обратном порядке в System.out.
Все числа влезают в int. Позиции чисел в последовательности нумеруются с нуля.
В этом задании надо написать программу целиком, включая import'ы, декларацию класса Main и метода main.

Sample Input:
1 2 3 4 5 6 7

Sample Output:
6 4 2
*/

import java.io.IOException;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        try {
            reverseEvenNumbers();
        }catch(Exception e){
        }
    }

    public static void reverseEvenNumbers() throws IOException {
        Deque<Integer> stack = new LinkedList<Integer>();
        Scanner scan = new Scanner(System.in);

        boolean even = true;
        while (scan.hasNext()) {
            if (scan.hasNextInt()) {
                if (even == false) {
                    stack.push(scan.nextInt());
                    even = true;
                } else {
                    scan.nextInt();
                    even = false;
                }
            } else {
                scan.next();
            }
        }

        while (stack.size() > 0) {
            System.out.print(stack.pop() + " ");
        }
    }
}


