package com.javarush.test.level19.lesson10.home01;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {

    public static void main(String[] args) throws IOException {
        String ss = args[0];
        BufferedReader br = new BufferedReader(new FileReader(ss));
        TreeMap<String, Double> map = new TreeMap<>();
        String s;
        while ((s = br.readLine()) != null){
            String [] arr = s.split(" ");
            Double d;
            try{
                d = Double.parseDouble(arr[1]);
                if(map.containsKey(arr[0])){
                    map.put(arr[0], d + map.get(arr[0]));
                } else {
                    map.put(arr[0], d);
                }
            }catch (Exception e){
                continue;
            }
        }
        for (Map.Entry<String, Double> pair : map.entrySet()){
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
        br.close();

    }
}
