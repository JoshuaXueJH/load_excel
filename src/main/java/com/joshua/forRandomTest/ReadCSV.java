package com.joshua.forRandomTest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ReadCSV {
    public static void main(String[] args) {
        List<String> allLines = null;
        try {
            Path path = Paths.get("/Users/xuejianhua/Desktop/SCB_MONIX_4680936049_20200128_132743_D");
            allLines = Files.readAllLines(path);
        } catch (IOException ex) {

        }

        for (String str : allLines) {
            System.out.println(str);
            System.out.println("==========");
        }
    }
}
