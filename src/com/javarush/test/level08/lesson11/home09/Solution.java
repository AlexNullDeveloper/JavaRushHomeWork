package com.javarush.test.level08.lesson11.home09;

import java.util.Date;

public class Solution
{
    public static void main(String[] args)
    {
        System.out.println(isDateOdd("MAY 1 2013"));
    }

    public static boolean isDateOdd(String date)
    {
        String[] temp = date.split(" ");

        Date before = new Date(date);
        Date after = new Date("JANUARY 0 " + date.split(" ")[2]);

        long difference = before.getTime() - after.getTime();

        int day = (int) (difference / (24 * 60 * 60 * 1000));


        if (day % 2 == 0)
        {
            return false;
        } else return true;

    }
}