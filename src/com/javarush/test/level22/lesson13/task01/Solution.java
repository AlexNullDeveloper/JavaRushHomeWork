package com.javarush.test.level22.lesson13.task01;

import java.util.ArrayList;
import java.util.StringTokenizer;

/* StringTokenizer
Используя StringTokenizer разделить query на части по разделителю delimiter.
Пример,
getTokens("level22.lesson13.task01", ".") == {"level22", "lesson13", "task01"}
*/
public class Solution {
    public static String [] getTokens(String query, String delimiter) {
        ArrayList<String> arrayList = new ArrayList<>();

        StringTokenizer stringTokenizer = new StringTokenizer(query, delimiter);
        while (stringTokenizer.hasMoreTokens()) {
            arrayList.add(stringTokenizer.nextToken());
        }
        String[] array = new String[arrayList.size()];
        return arrayList.toArray(array);
    }


    public static void main(String[] args) {
        String[] tokens = Solution.getTokens("level22.lesson13.task01", ".");
        for (int i = 0; i < tokens.length; i++) {
            System.out.println(tokens[i]);
        }
    }

}
