package com.sq.stepik_org.les03; // Created by SquorpikkoR on 09.01.2017.

//region TASK DESCRIPTION
/*
        декодирование Хаффмана

        Восстановите строку по её коду и беспрефиксному коду символов.
        В первой строке входного файла заданы два целых числа k
        и l через пробел — количество различных букв, встречающихся в строке,
        и размер получившейся закодированной строки, соответственно. В следующих k
        строках записаны коды букв в формате "letter: code". Ни один код не является
        префиксом другого. Буквы могут быть перечислены в любом порядке. В качестве
        букв могут встречаться лишь строчные буквы латинского алфавита; каждая из этих
        букв встречается в строке хотя бы один раз. Наконец, в последней строке записана
        закодированная строка. Исходная строка и коды всех букв непусты. Заданный код таков,
        что закодированная строка имеет минимальный возможный размер.

        В первой строке выходного файла выведите строку s. Она должна состоять из строчных букв
        латинского алфавита. Гарантируется, что длина правильного ответа не превосходит 10_4
        символов.

        Sample Input 1:
        1 1
        a: 0
        0

        Sample Output 1:
        a

        Sample Input 2:
        4 14
        a: 0
        b: 10
        c: 110
        d: 111
        01001100100111

        Sample Output 2:
        abacabad
*/
//endregion

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Huffman_2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        ///////String root = System.getProperty("user.dir") + "/src/";  //Вариант для ввода значений из файла(три строчки)
        ///////File file = new File(root + "com/sq/stepik_org/les03/encodeHuffman.txt");
        ///////Scanner scanner = new Scanner(file);
        int k = scanner.nextInt();//количество различных букв, встречающихся в строке
        int l = scanner.nextInt();//размер получившейся закодированной строки

        Character value;
        String key;
        Map<String,Character> codeMap = new HashMap<>(k);
        for (int i = 0; i < k; i++) {
            value = scanner.next().charAt(0);
            key = scanner.next();
            codeMap.put(key, value);
        }

        String code = scanner.next();

        String result = "";
        String codeToCheck = "";
        int j = 1;
        for (int i = 0; i < code.length(); ) {
                do{//МОЖНО СДЕЛАТЬ ЧЕРЕЗ WHILE, ТАК БУДЕТ БЕЗ J-- И ВООБЩЕ КОРОЧЕ, НО ЧИТАТЬ СТАНОВИТСЯ СЛОЖНЕЕ. БУДЕТ ВРЕМЯ -- ОТРЕФАКТОРЮ
                    codeToCheck = code.substring(i, i + j);
                   j++;
                }while(!codeMap.containsKey(codeToCheck));
            j--;
                result += codeMap.get(codeToCheck);
            codeToCheck = "";
            i = i + j;
            j=1;
        }

        System.out.println(result);

    }

}












