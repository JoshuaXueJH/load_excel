package com.joshua.ricoh;

import java.util.List;

import static com.joshua.ando.SplitSentence.strToken;

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


}
