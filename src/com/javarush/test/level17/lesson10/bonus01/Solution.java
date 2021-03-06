package com.javarush.test.level17.lesson10.bonus01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD
CrUD - Create, Update, Delete
Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-c  - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u  - обновляет данные человека с данным id
-d  - производит логическое удаление человека с id
-i  - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)

id соответствует индексу в списке
Все люди должны храниться в allPeople
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример параметров: -c Миронов м 15/04/1990
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        switch (args[0]) {
            case "-c":
                String name = args[1];
                Date bd = format.parse(args[3]);
                Person pers;
                if ("м".equals(args[2])) pers = Person.createMale(name, bd);
                else pers = Person.createFemale(name, bd);
                allPeople.add(pers);
                System.out.println(allPeople.indexOf(pers));
                break;
            case "-u":
                Person p = allPeople.get(Integer.parseInt(args[1]));
                p.setName(args[2]);
                p.setSex("м".equals(args[3]) ? Sex.MALE : Sex.FEMALE);
                p.setBirthDay(format.parse(args[4]));
                break;
            case "-d":
                p = allPeople.get(Integer.parseInt(args[1]));
                p.setBirthDay(null);
                p.setSex(null);
                p.setName(null);
                break;
            case "-i":
                p = allPeople.get(Integer.parseInt(args[1]));
                System.out.printf("%s %s %s", p.getName(), p.getSex().equals(Sex.MALE) ? "м" : "ж", new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).format(p.getBirthDay()));
                break;
        }
    }
}
