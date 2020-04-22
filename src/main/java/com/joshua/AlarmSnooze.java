package com.joshua;

import java.util.Calendar;
import java.util.Date;

public class AlarmSnooze {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        System.out.println("real time: " + cal.getTime());
/*        cal.set(Calendar.HOUR_OF_DAY, 22);
        cal.set(Calendar.MINUTE, 38);*/
        System.out.println("modified time: " + cal.getTime());

        boolean result = shouldSnoozeBetween(cal, 22, 15);
        System.out.println(result);
    }


    /**
     * @param startHourOfDay 24 hours format
     * @param endHourOfDay   24 hours format
     * @return
     */
    public static boolean shouldSnoozeBetween(Calendar cal, Integer startHourOfDay, Integer endHourOfDay) {
        if (startHourOfDay == null || endHourOfDay == null) {
            return false;
        }
        return shouldSnoozeBetween(cal, startHourOfDay, 0, endHourOfDay, 0);
    }

    /**
     * @param startHourOfDay 24 hours format
     * @param endHourOfDay   24 hours format
     * @return
     */
    public static boolean shouldSnoozeBetween(Calendar cal, Integer startHourOfDay, Integer startMinuteOfHour,
                                              Integer endHourOfDay, Integer endMinuteOfHour) {
        if (startHourOfDay == null || startMinuteOfHour == null ||
                endHourOfDay == null || endMinuteOfHour == null) {
            return false;
        }

        if (startHourOfDay < 0 || startHourOfDay > 23 ||
                endHourOfDay < 0 || endHourOfDay > 23 ||
                startMinuteOfHour < 0 || startMinuteOfHour > 60 ||
                endMinuteOfHour < 0 || endMinuteOfHour > 60) {
            return false;
        }

/*        Calendar now = Calendar.getInstance(TimeZone.getTimeZone("GMT+8:00"));
        now.setTime(new Date());*/
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int minute = cal.get(Calendar.MINUTE);

        if (startHourOfDay < endHourOfDay) {
            if (hour < startHourOfDay || hour > endHourOfDay) {
                return false;
            } else if (hour == startHourOfDay && minute < startMinuteOfHour) {
                return false;
            } else if (hour == endHourOfDay && minute >= endMinuteOfHour) {
                return false;
            } else {
                return true;
            }
        } else if (startHourOfDay > endHourOfDay) {
            if (hour > startHourOfDay) {
                return true;
            } else if (hour == startHourOfDay && minute >= startMinuteOfHour) {
                return true;
            } else if (hour < endHourOfDay) {
                return true;
            } else if (hour == endHourOfDay && minute < endMinuteOfHour) {
                return true;
            } else {
                return false;
            }
        } else {
            if (minute >= startMinuteOfHour && minute < endMinuteOfHour) {
                return true;
            } else {
                return false;
            }
        }
    }
}
