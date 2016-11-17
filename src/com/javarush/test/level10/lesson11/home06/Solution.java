package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
      private int age;
        private int weight;
        private    int height;
        private String adress;
       private Human kids;
        private String gorod;

        public Human(int age) {
            this.age = age;
        }

        public Human(String adress) {
            this.adress = adress;
        }

        public Human(Human kids) {
            this.kids = kids;
        }

        public Human(int age, int weight) {
            this.age = age;
            this.weight = weight;
        }

        public Human(int age, String gorod) {
            this.age = age;
            this.gorod = gorod;
        }

        public Human(String adress, Human kids) {
            this.adress = adress;
            this.kids = kids;
        }

        public Human(int age, Human kids) {
            this.age = age;
            this.kids = kids;
        }

        public Human(String adress, String gorod) {
            this.adress = adress;
            this.gorod = gorod;
        }

        public Human(int age, String adress, Human kids) {
            this.age = age;
            this.adress = adress;
            this.kids = kids;
        }

        public Human(int age, int height, String adress) {
            this.age = age;
            this.height = height;
            this.adress = adress;
        }
    }
}
