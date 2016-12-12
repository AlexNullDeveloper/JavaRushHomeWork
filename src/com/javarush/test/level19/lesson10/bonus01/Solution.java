package com.javarush.test.level19.lesson10.bonus01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Отслеживаем изменения
Считать в консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME
Пример:
оригинальный   редактированный    общий
file1:         file2:             результат:(lines)

строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка4                           REMOVED строка4
строка5        строка5            SAME строка5
строка0                           ADDED строка0
строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка5                           ADDED строка5
строка4        строка4            SAME строка4
строка5                           REMOVED строка5
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = bufferedReader.readLine();
        String fileName2 = bufferedReader.readLine();
        bufferedReader.close();

        BufferedReader bufferedReader1 = new BufferedReader(new FileReader(fileName1));
        BufferedReader bufferedReader2 = new BufferedReader(new FileReader(fileName2));

        List<String> l1 = new ArrayList<>();
        List<String> l2 = new ArrayList<>();
        while (bufferedReader1.ready()) {
            l1.add(bufferedReader1.readLine());
        }
        while (bufferedReader2.ready()) {
            l2.add(bufferedReader2.readLine());
        }
        int j = 0;
        for (int i = 0; i < l1.size(); i++) {
            if (j >= l2.size()) {
                lines.add(new LineItem(Type.REMOVED, l1.get(i)));
                break;
            } else if (l1.get(i).equals(l2.get(j))) {
                lines.add(new LineItem(Type.SAME, l1.get(i)));
                j++;
            } else if (j < (l2.size() - 1) && l1.get(i).equals(l2.get(j + 1))) {
                lines.add(new LineItem(Type.ADDED, l2.get(j)));
                j++;
                i--;
            } else if (i < (l1.size() - 1) && l1.get(i + 1).equals(l2.get(j))) {
                lines.add(new LineItem(Type.REMOVED, l1.get(i)));
            }
        }
        if (lines.get(lines.size() - 1).type == Type.SAME && j <= (l2.size() - 1)) {
            lines.add(new LineItem(Type.ADDED, l2.get(j)));
        }
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
