package com.joshua.forRandomTest;

import java.time.LocalDate;

public class DateTimeTest {

    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2020, 2, 2);
        System.out.println("year" + date.getYear());
        System.out.println("month" + date.getMonth().getValue());
        System.out.println("day" + date.getDayOfMonth());
    }
}

