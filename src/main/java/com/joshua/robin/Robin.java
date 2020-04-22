package com.joshua.robin;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Robin {
    static List<String> strTokens(String sentence, String delimiters) {
        delimiters = "[" + delimiters + "]";
        return Arrays.asList(sentence.split(delimiters)).stream().filter((e -> !e.isEmpty())).collect(Collectors.toList());
    }

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
}
