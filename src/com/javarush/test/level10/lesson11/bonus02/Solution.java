package com.javarush.test.level10.lesson11.bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String,Integer> map = new HashMap<String,Integer>();

        while(true ) {
            int number;

            String s = reader.readLine();
            if(!s.equals(""))
                number = Integer.parseInt(s);

            else break;

            String name = reader.readLine();
            if (name.equals("")) break;

            map.put(name,number) ;
        }

        for (Map.Entry<String,Integer> pair: map.entrySet()) {
            System.out.println(pair.getValue() + " " + pair.getKey());
        }
    }
}