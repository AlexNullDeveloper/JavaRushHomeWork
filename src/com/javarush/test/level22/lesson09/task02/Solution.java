package com.javarush.test.level22.lesson09.task02;

import java.util.HashMap;
import java.util.Map;

/* Формируем Where
Сформируйте часть запроса WHERE используя StringBuilder.
Если значение null, то параметр не должен попадать в запрос.
Пример:
{"name", "Ivanov", "country", "Ukraine", "city", "Kiev", "age", null}
Результат:
"name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'"
*/
public class Solution {

    public static void main(String[] args) {
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put("name", "Ivanov");
        stringStringHashMap.put("country", "Ukraine");
        stringStringHashMap.put("city", "Kiev");
        stringStringHashMap.put("age", null);
        System.out.println(Solution.getCondition(stringStringHashMap));
    }

    public static StringBuilder getCondition(Map<String, String> params) {
        StringBuilder stringBuilder = new StringBuilder("");
        for (Map.Entry<String,String> entry : params.entrySet()) {

            if (!(entry.getValue() == null)) {
                if (!stringBuilder.toString().equals("")) {
                    stringBuilder.append(" and ");
                }
                stringBuilder.append(entry.getKey()).append(" = '").append(entry.getValue()).append("'");
            }
        }
        return stringBuilder;
    }
}
