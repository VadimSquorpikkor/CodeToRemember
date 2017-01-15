package com.sq.stepik_org.les03; // Created by SquorpikkoR on 14.01.2017.

//Описание алгоритма:
//https://stepik.org/lesson/%D0%9F%D1%80%D0%B0%D0%BA%D1%82%D0%B8%D0%BA%D0%B0-%D0%BD%D0%B0-Java-%D0%9A%D0%BE%D0%B4%D1%8B-%D0%A5%D0%B0%D1%84%D1%84%D0%BC%D0%B0%D0%BD%D0%B0-16968/step/1?course=%D0%90%D0%BB%D0%B3%D0%BE%D1%80%D0%B8%D1%82%D0%BC%D1%8B-%D1%82%D0%B5%D0%BE%D1%80%D0%B8%D1%8F-%D0%B8-%D0%BF%D1%80%D0%B0%D0%BA%D1%82%D0%B8%D0%BA%D0%B0-%D0%9C%D0%B5%D1%82%D0%BE%D0%B4%D1%8B&unit=4499

//Код полностью рабочий (проходит все тесты), но его можно улучшить, значительно увеличив скорость
//работы применив StringBuilder вместо String. Как это делать см. ссылку, последнюю часть

//region TASK
/*
        кодирование Хаффмана

        По данной непустой строке s длины не более 10_4, состоящей из строчных букв
        латинского алфавита, постройте оптимальный беспрефиксный код. В первой строке
        выведите количество различных букв k, встречающихся в строке, и размер получившейся
        закодированной строки. В следующих k строках запишите коды букв в формате "letter: code".
        В последней строке выведите закодированную строку.

        Sample Input 1:
        a

        Sample Output 1:
        1 1
        a: 0
        0

        Sample Input 2:
        abacabad

        Sample Output 2:
        4 14
        a: 0
        b: 10
        c: 110
        d: 111
        01001100100111
*/
//endregion

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class HufmanCodding {

    class Node implements Comparable<Node>{ //Узел. Могут быть внутренними и листьями.
        final int sum;    //sum -- для того, чтобы в каждом узле хранить сумарную частоту встречающихся
                    // символов, которые лежат в данном поддереве

        String code = "";//Для хранения кода символа

        void buildCode(String code) {
            this.code = code;
        }

        public Node(int sum) {//добавлено длязамены на использование конструктора
            // родителя для подсчета суммы (+ sum стал final)
            this.sum = sum;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(sum, o.sum);
        }
    }

    class InternalNode extends Node{ //внутренний узел
        Node left;
        Node right;

        @Override
        void buildCode(String code) {
            super.buildCode(code);
            left.buildCode(code + "0");
            right.buildCode(code + "1");
        }

        public InternalNode(Node left, Node right) {
            super(left.sum + right.sum);//Исползуем конструктор родителя!
            this.left = left;
            this.right = right;
            //sum = left.sum + right.sum; //Заменено на использование конструктора
            // родителя -- то же, но уже закидывается в super
        }
    }

    class LeafNode extends Node {
        char symbol;

        @Override
        void buildCode(String code) {
            super.buildCode(code);
            System.out.println(symbol + ": " + code);
        }

        public LeafNode(char symbol, int count) {
            super(count);//Исползуем конструктор родителя!
            this.symbol = symbol;
            //sum = count;//Заменено на использование конструктора
            // родителя -- то же, но уже закидывается в super
        }
    }


    void run() {
        Scanner scanner = new Scanner(System.in);
        String stroke = scanner.nextLine();
        Map<Character, Integer> codeMap = new HashMap<>();
        for (int i = 0; i < stroke.length(); i++) {
            char c = stroke.charAt(i);
            if (codeMap.containsKey(c)) {
                codeMap.put(c, codeMap.get(c) + 1);
            } else {
                codeMap.put(c, 1);
            }
        }

        /*for (Map.Entry<Character, Integer> entry: codeMap.entrySet()) {
            //System.out.println(entry); //можно и так, но так как в след строке удобнее, можно по-всякому крутить значения
            System.out.println(entry.getKey() + " : " + entry.getValue());

        }*/ //для вывода Map (сразу парами)

        Map<Character, Node> charNodes = new HashMap<>();
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(); // Ctrl + Q -- посмотреть описание
        //add -- иоложить элемент
        //peek -- достать элемент на вершине очереди
        //poll -- удалить его
        //На вершине очереди хранится минимальный элемент
        for (Map.Entry<Character, Integer> entry : codeMap.entrySet()) {//читаем значения из Map'а и закидываем
            LeafNode node = new LeafNode(entry.getKey(), entry.getValue());
            charNodes.put(entry.getKey(), node);
            priorityQueue.add(node);//в Queue (там он автоматом сортируется)
        }
        int sum = 0;
        while (priorityQueue.size() > 1) {
            Node first = priorityQueue.poll(); //Забираем из очереди узел
            Node second = priorityQueue.poll();//Забираем из очереди узел
            InternalNode node = new InternalNode(first, second);//Из двух узлов (они могут быть и листьями и InternalNode -- удобство полиморфизма) собирается один InternalNode
            sum += node.sum;
            priorityQueue.add(node);
        }
        if (codeMap.size() == 1) {//Нужно только для случаев, когда кол-во символов = 1
            sum = stroke.length();//
        }
        System.out.println(codeMap.size() + " " + sum);
        Node root = priorityQueue.poll();
        if (codeMap.size() == 1) {//Нужно только для случаев, когда кол-во символов = 1
            root.buildCode("0");
        } else {
            root.buildCode("");
        }

        String encodedString = "";
        for (int i = 0; i < stroke.length(); i++) {
            char c = stroke.charAt(i);
            encodedString += charNodes.get(c).code;
        }
        System.out.println(encodedString);
    }

    public static void main(String[] args) {
        //long startTime = System.currentTimeMillis();
        new HufmanCodding().run();
        //long endTime = System.currentTimeMillis();
        //System.out.println(endTime - startTime + " ms");
    }

}
