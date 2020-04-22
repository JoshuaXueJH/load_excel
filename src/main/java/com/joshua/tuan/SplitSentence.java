package com.joshua.tuan;

import java.util.ArrayList;
import java.util.List;

public class SplitSentence {
    public static void main(String[] args) {
        String sentence = "   n           can     not learn anymore       in this company.... market move slowing, can not speak German, looking for new challenges. he's here, come on!! come on! come! ";
        String delimiters = " \t\r\n?!.;,#";

        List<String> result = strToken(sentence, delimiters);

        System.out.println("--");
        for (String str : result) {
            System.out.println(str);
        }
        System.out.println("--");
    }

    private static List<String> strToken(String sourceStr, String delimitors) {
        List<String> words = new ArrayList<String>();

        StringBuffer wordBuffer = new StringBuffer();
        for (int i = 0; i < sourceStr.length(); ++i) {
            char c = sourceStr.charAt(i);

            if (isDelimitor(c, delimitors)) {
                String word = wordBuffer.toString();
                if (word.length() != 0) {
                    words.add(wordBuffer.toString());
                    wordBuffer = new StringBuffer();
                }

                continue;
            }

            wordBuffer.append(c);
        }

        return words;
    }

    private static boolean isDelimitor(char c, String delimitors) {
        return delimitors.indexOf(c) != -1;
    }
}
