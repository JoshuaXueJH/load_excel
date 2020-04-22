package com.joshua.koha;

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

    public static List<String> strToken(String sentence, String delimitors) {
        List<String> result = new ArrayList<String>();
        if(sentence == null) {
            return result;
        }
        if(delimitors == null) {
            result.add(sentence);
        }
        String[] arrString ;
        arrString = sentence.split("[ ]+");
        delimitors = delimitors.replaceAll(" ", "");

        for(int i=0; i<arrString.length; i++ ) {
            String element = arrString[i];
            for(int j=0; j<delimitors.length(); j++ ) {
                element = element.replaceAll(String.valueOf(delimitors.charAt(j)), "");
            }
            result.add(element);
        }

        return result;
    }

}
