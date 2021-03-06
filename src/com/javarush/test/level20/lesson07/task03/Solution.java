package com.javarush.test.level20.lesson07.task03;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* Externalizable Person
Класс Person должен сериализоваться с помощью интерфейса Externalizable.
Подумайте, какие поля не нужно сериализовать.
Исправьте ошибку сериализации.
Сигнатуры методов менять нельзя.
*/
public class Solution {
    public static class Person implements Externalizable {
        private String firstName;
        private String lastName;
        private int age;
        private Person mother;
        private Person father;
        private List<Person> children;

        public Person() {

        }

        public Person(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

        public void setMother(Person mother) {
            this.mother = mother;
        }

        public void setFather(Person father) {
            this.father = father;
        }

        public void setChildren(List<Person> children) {
            this.children = children;
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(firstName);
            out.writeObject(lastName);
            out.writeInt(age);
            out.writeObject(mother);
            out.writeObject(father);
            out.writeObject(children);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            firstName = (String) in.readObject();
            lastName = (String) in.readObject();
            age = in.readInt();
            mother = (Person)in.readObject();
            father = (Person)in.readObject();
            children = (List<Person>)in.readObject();
        }
    }

    public static void main(String[] args) {
        Person person = new Person("Name", "Lastname", 25);
        Person mom = new Person("M", "Mom", 45);
        Person dad = new Person("D", "Dad", 48);
        Person son = new Person("Son", "Sonov", 6);
        Person dot = new Person("Dot", "Dotova", 4);
        List<Person> children = new ArrayList<>();
        children.add(son);
        children.add(dot);
        person.setMother(mom);
        person.setFather(dad);
        person.setChildren(children);

        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("/home/talismanov/file.tmp"));
            objectOutputStream.writeObject(person);
            objectOutputStream.close();

            ObjectInputStream input = new ObjectInputStream(new FileInputStream("/home/talismanov/file.tmp"));
            Person person1 = (Person) input.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}

