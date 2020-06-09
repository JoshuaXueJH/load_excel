package com.joshua;

public class Son extends Father {
    public static String str2 = "this is static var in Son. ";

    static {
        System.out.println("static part in son. ");
    }

    {
        System.out.println("non static part in son. ");
    }

    Son() {
        super();
        System.out.println("construction method of son. ");
    }

    public InnerSon getInnerSon() {
        return new InnerSon();
    }

    private static class InnerSon {
        static {
            System.out.println("static part in inner son. ");
        }

        {
            System.out.println("non static part in inner son. ");
        }

        InnerSon() {
            System.out.println("construction method of inner son. ");
        }
    }

    public static void main(String[] args) {
        Son son = new Son();
        son.getInnerSon();
    }
}
