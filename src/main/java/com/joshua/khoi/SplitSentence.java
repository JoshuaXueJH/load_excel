package com.joshua.khoi;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SplitSentence {
    public static void main(String[] args) {
        String sentence = "   n           can     not learn anymore       in this company.... market move slowing, can not speak German, looking for new challenges. he's here, come on!! come on! come! ";
        String delimiters = " \t\r\n?!.;,#";
        List<String> result = strTokens(sentence, delimiters);

        System.out.println("--");
        for (String str : result) {
            System.out.println(str);
        }
        System.out.println("--");
    }

    public static List<String> strTokens(String sentence, String delimiters) {
        String[] parts = sentence.split("\\s+");
        return Stream.of(parts).map(p -> {
            for (int i = sentence.length(); i >= 0 ; i--) {
                //strip all special chars
            }
            return p;
        }).collect(Collectors.toList());

    }
}
