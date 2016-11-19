package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution
{
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        BufferedReader bufferedReader1 = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));

        ArrayList<Integer> arrayList = new ArrayList<>();
        String line;
        while ((line = bufferedReader1.readLine())!= null) {
            try {
                int integer = Integer.parseInt(line);
                if (integer % 2 == 0) {
                    arrayList.add(integer);
                }
            } catch (NumberFormatException e) {

            }
        }

        Collections.sort(arrayList);

        for (Integer integer : arrayList) {
            System.out.println(integer);
        }


    }
}
