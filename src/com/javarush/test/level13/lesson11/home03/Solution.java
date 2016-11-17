package com.javarush.test.level13.lesson11.home03;

/* Чтение файла
1. Считать с консоли имя файла.
2. Вывести в консоль(на экран) содержимое файла.
3. Не забыть освободить ресурсы. Закрыть поток чтения с файла и поток ввода с клавиатуры.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileIn = bufferedReader.readLine();
        //add your code here

        try {
            File file = new File(fileIn);
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "windows-1251"));
            String str;

            while ((str = bufferedReader.readLine()) != null) {
                System.out.println(str);
            }

        } catch (UnsupportedEncodingException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            bufferedReader.close();
        }
    }
}
