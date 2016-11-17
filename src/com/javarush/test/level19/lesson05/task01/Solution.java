package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
Закрыть потоки ввода-вывода.
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String firstFile = br.readLine();
        String secondFile = br.readLine();
        FileReader fileReader = new FileReader(firstFile);
        FileWriter fileWriter = new FileWriter(secondFile);
        ArrayList<Integer> list = new ArrayList<Integer>();
        while (fileReader.ready()){
            int data = fileReader.read();
            list.add(data);
        }

        for (int i = 1; i < list.size(); i += 2) {
            fileWriter.write(list.get(i));
        }

        fileWriter.close();
        fileReader.close();
    }
}