package com.joshua.fredric;

import java.util.Arrays;
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
        String newDelimitors = "";

        char[] character = delimitors.toCharArray();

        for(int i=0; i<character.length; i++){
            newDelimitors+="\\"+character[i];
            if(i!=character.length-1){
                newDelimitors+="|";
            }
        }

        String[] word = sentence.split(newDelimitors);

        List<String> myStringList = Arrays.asList(word);

        for(int i=0; i<myStringList.size(); i++){
            //System.out.println(myStringList.get(i));
        }

        return myStringList;
    }
}
