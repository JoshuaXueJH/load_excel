package com.joshua.ando;

import java.util.ArrayList;
import java.util.List;

public class SplitSentence {
    public static void main(String[] args) {
        String sentence = "   n           can:  not learn anymore       in this company.... market move slowing, can not speak German, looking for new challenges. he's here, come on!! come on! come! ";
        String delimiters = " \t\r\n?!.;,#";
        //String delimiters = ".";
        List<String> result = strToken(sentence, delimiters);

        System.out.println("--");
        for (String str : result) {
            System.out.println(str);
        }
        System.out.println("--");
    }

    public static List<String> strToken(String sentence, String delimitors) {
        List<String> res = new ArrayList<>();
        if (sentence == null || sentence.isEmpty())
            return res;

        if (delimitors == null || delimitors.isEmpty()) {
            res.add(sentence);
            return res;
        }

        String tmp = "";
        char[] inputArr = sentence.toCharArray();
        for (char in : inputArr) {
            if (delimitors.contains("" + in)) {
                if (!tmp.isEmpty()) {
                    res.add(tmp);
                }
                tmp = "";
                continue;
            }
            tmp += in;
        }

        return res;
    }

}
