package com.sq._java_basic_course.RoleList; // Created by SquorpikkoR on 05.02.2017.

//region TASK
/*
Вам дан список ролей и сценарий пьесы в виде массива строчек.

        Каждая строчка сценария пьесы дана в следующем виде:
        Роль: текст

        Текст может содержать любые символы.

        Напишите метод, который будет группировать строчки по ролям, пронумеровывать их и возвращать результат в виде готового текста (см. пример). Каждая группа распечатывается в следующем виде:

        Роль:
        i) текст
        j) текст2
        ...
        ==перевод строки==

        i и j -- номера строк в сценарии. Индексация строчек начинается с единицы, выводить группы следует в соответствии с порядком ролей. Переводы строк между группами обязательны, переводы строк в конце текста не учитываются.

        Заметим, что вам предстоит обработка огромной пьесы в 50 000 строк для 10 ролей – соответственно, неправильная сборка результирующей строчки может выйти за ограничение по времени.

        Обратите внимание еще на несколько нюансов:

        имя персонажа может встречаться в строке более одного раза, в том числе с двоеточием;
        название одной роли может быть префиксом названия другой роли (например, "Лука" и "Лука Лукич");
        роль, у которой нет реплик, тоже должна присутствовать в выходном файле;
        в качестве перевода строки надо использовать символ '\n' (перевод строки в стиле UNIX);
        будьте внимательны, не добавляйте лишних пробелов в конце строк.

        Sample Input:

        roles:
        Городничий
        Аммос Федорович
        Артемий Филиппович
        Лука Лукич
        textLines:
        Городничий: Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор.
        Аммос Федорович: Как ревизор?
        Артемий Филиппович: Как ревизор?
        Городничий: Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.
        Аммос Федорович: Вот те на!
        Артемий Филиппович: Вот не было заботы, так подай!
        Лука Лукич: Господи боже! еще и с секретным предписаньем!

        Sample Output:

        Городничий:
        1) Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор.
        4) Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.

        Аммос Федорович:
        2) Как ревизор?
        5) Вот те на!

        Артемий Филиппович:
        3) Как ревизор?
        6) Вот не было заботы, так подай!

        Лука Лукич:
        7) Господи боже! еще и с секретным предписаньем!
*/
//endregion

import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        String[] roles = {
                "Городничий",
                "Аммос Федорович",
                "Артемий Филиппович",
                "Лука Лукич"
        };
        String[] textLines = {
                "Городничий: Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор.",
                "Аммос Федорович: Как ревизор?",
                "Артемий Филиппович: Как ревизор?",
                "Городничий: Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.",
                "Аммос Федорович: Вот те на!",
                "Артемий Филиппович: Вот не было заботы, так подай!",
                "Лука Лукич: Господи боже! еще и с секретным предписаньем!"
        };

        System.out.println(new Main().printTextPerRole(roles, textLines));
    }

    /*private String printTextPerRole(String[] roles, String[] textLines) {//Не проходии по времени
        HashMap<String, String> roleCollector = new HashMap<>();
        for (int i = 0; i < roles.length; i++) {
            roleCollector.put(roles[i], "");
        }
        for (int i = 0; i < textLines.length; i++) {
            int k = 0;
            String tempName = "";
            String tempText = "";
            StringBuilder tN = new StringBuilder();
            StringBuilder tT = new StringBuilder();
            while (textLines[i].charAt(k) != ':') {
                tempName += textLines[i].charAt(k);
                k++;
            }
            k+=2;//Пропускаю ':' и ' ' после имени
            tempText = (i+1) + ") " + textLines[i].substring(k) + "\n";//Копировать оставшуюся часть строки
            roleCollector.put(tempName, roleCollector.get(tempName) + tempText);
        }
        String res = "";
        for (int j = 0; j < roles.length; j++) {
            res += roles[j]+":" + "\n" + roleCollector.get(roles[j]) + "\n";
        }
        return res;
    }*/

    private String printTextPerRole(String[] roles, String[] textLines) {//Стринги заменены нв стрингбилдер. Не проходии по времени
        HashMap<String, String> roleCollector = new HashMap<>();
        for (String role : roles) {
            roleCollector.put(role, "");
        }
        for (int i = 0; i < textLines.length; i++) {
            int k = 0;
            StringBuilder tN = new StringBuilder();
            StringBuilder tT = new StringBuilder();
            while (textLines[i].charAt(k) != ':') {
                tN = tN.append(textLines[i].charAt(k));
                k++;
            }
            k+=2;//Пропускаю ':' и ' ' после имени
            tT = tT.append(i + 1).append(") ").append(textLines[i].substring(k)).append("\n");//Копировать оставшуюся часть строки
            roleCollector.put(tN.toString(), roleCollector.get(tN.toString()) + tT);
        }
        StringBuilder res = new StringBuilder();
        for (String role : roles) {
            res = res.append(role).append(":").append("\n").append(roleCollector.get(role)).append("\n");
        }
        return res.toString();
    }

    /*private String printTextPerRole(String[] roles, String[] textLines) {
        StringBuilder answer = new StringBuilder();
        for (String role : roles) {
            answer.append(role + ":\n");
            for (int i = 0; i < textLines.length; i++) {
                if (textLines[i].startsWith(role + ":")) {
                    answer.append((i+1) + ")" + textLines[i].substring(role.length() + 1) + "\n");
                }
            }
            answer.append("\n");
        }
        return answer.toString();
    }*/

























}
