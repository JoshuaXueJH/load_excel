package com.joshua.today;


import java.util.ArrayList;
import java.util.List;

public class cipto {
    public static void main(String[] args) {
        String sentence = "   n           can     not learn anymore       in this company.... market move slowing, can not speak German, looking for new challenges. he's here, come on!! come on! come! ";
        String delimiters = " \t\r\n?!.;,#";
        List<String> result = splitSentence(sentence, delimiters);

        System.out.println("--");
        for (String str : result) {
            System.out.println(str);
        }
        System.out.println("--");
    }

    public static List<String> splitSentence(String str, String delimiters) {
        List<String> result = new ArrayList<>();
        String[] results = str.split("[" + delimiters + "]");
        for (int i = 0; i < results.length; i++) {
            String item = results[i];
            if (item.equals(""))
                continue;
            result.add(item);
        }
        return result;
    }
}
