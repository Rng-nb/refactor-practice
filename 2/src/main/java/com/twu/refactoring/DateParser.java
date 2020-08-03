package com.twu.refactoring;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.TimeZone;

public class DateParser {
    private final String dateAndTimeString;
    private static final HashMap<String, TimeZone> KNOWN_TIME_ZONES = new HashMap<String, TimeZone>();

    static {
        KNOWN_TIME_ZONES.put("UTC", TimeZone.getTimeZone("UTC"));
    }

    /**
     * Takes a date in ISO 8601 format and returns a date
     *
     * @param dateAndTimeString - should be in format ISO 8601 format
     *                          examples -
     *                          2012-06-17 is 17th June 2012 - 00:00 in UTC TimeZone
     *                          2012-06-17TZ is 17th June 2012 - 00:00 in UTC TimeZone
     *                          2012-06-17T15:00Z is 17th June 2012 - 15:00 in UTC TimeZone
     */
    public DateParser(String dateAndTimeString) {
        this.dateAndTimeString = dateAndTimeString;
    }

    public Date parse() {
        int year = getYear();
        int month = getMonth();
        int date = getDate();
        int hour = getHour();
        int minute = getMinute();

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("UTC"));
        calendar.set(year, month - 1, date, hour, minute, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    private int getYear() {
        int year = 0;
        try {
            String yearString = dateAndTimeString.substring(0, 4);
            year = Integer.parseInt(yearString);
        } catch (StringIndexOutOfBoundsException e) {
            throwOutException("Year string is less than 4 characters");
        } catch (NumberFormatException e) {
            throwOutException("Year is not an integer");
        }

        if (year < 2000 || year > 2012)
            throwOutException("Year cannot be less than 2000 or more than 2012");

        return year;
    }

    private int getMonth() {
        int month = 0;
        try {
            String monthString = dateAndTimeString.substring(5, 7);
            month = Integer.parseInt(monthString);
        } catch (StringIndexOutOfBoundsException e) {
            throwOutException("Month string is less than 2 characters");
        } catch (NumberFormatException e) {
            throwOutException("Month is not an integer");
        }

        if (month < 1 || month > 12)
            throwOutException("Month cannot be less than 1 or more than 12");

        return month;
    }

    private int getDate() {
        int date = 0;
        try {
            String dateString = dateAndTimeString.substring(8, 10);
            date = Integer.parseInt(dateString);
        } catch (StringIndexOutOfBoundsException e) {
            throwOutException("Date string is less than 2 characters");
        } catch (NumberFormatException e) {
            throwOutException("Date is not an integer");
        }

        if (date < 1 || date > 31)
            throwOutException("Date cannot be less than 1 or more than 31");
        return date;
    }

    private int getHour() {
        int hour = 0;
        if (dateAndTimeString.substring(11, 12).equals("Z"))
            return 0;

        try {
            String hourString = dateAndTimeString.substring(11, 13);
            hour = Integer.parseInt(hourString);
        } catch (StringIndexOutOfBoundsException e) {
            throwOutException("Hour string is less than 2 characters");
        } catch (NumberFormatException e) {
            throwOutException("Hour is not an integer");
        }
        if (hour < 0 || hour > 23)
            throwOutException("Hour cannot be less than 0 or more than 23");
        return hour;
    }

    private int getMinute() {
        int minute = 0;
        if (dateAndTimeString.substring(11, 12).equals("Z"))
            return 0;
        try {
            String minuteString = dateAndTimeString.substring(14, 16);
            minute = Integer.parseInt(minuteString);
        } catch (StringIndexOutOfBoundsException e) {
            throwOutException("Minute string is less than 2 characters");
        } catch (NumberFormatException e) {
            throwOutException("Minute is not an integer");
        }
        if (minute < 0 || minute > 59)
            throwOutException("Minute cannot be less than 0 or more than 59");
        return minute;
    }

    private void throwOutException(String exceptionMessage) {
        throw new IllegalArgumentException(exceptionMessage);
    }
}
