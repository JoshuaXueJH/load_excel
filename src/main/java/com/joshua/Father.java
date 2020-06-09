package com.joshua;

public class Father {
    public static String str1 = "this is static var in father. ";

    static {
        System.out.println("static part in father. ");
    }

    {
        System.out.println("non static part in father. ");
    }

    Father() {
        System.out.println("construction method in father. ");
    }
}
