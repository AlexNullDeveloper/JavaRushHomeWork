package com.javarush.test.level13.lesson11.home04;

/* Запись в файл
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Вывести абсолютно все введенные строки в файл, каждую строчку с новой стороки.
*/

import java.io.*;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> array = new ArrayList<String>();

//        String fileOut = "c:\\tmp\\in.txt";
        String fileOut = reader.readLine();

        while (true) {
            String read = reader.readLine();
            if (read.equals("exit")) {
                array.add(read);
                break;
            }
            array.add(read);
        }

// В условии не нужно делать проверку
        File file = new File(fileOut);
        if(!file.exists()){
            file.createNewFile();
        }

        FileWriter out = new FileWriter(file);
        for (String s : array) {
            out.write(s + "\n");
        }

        out.close();
    }
}