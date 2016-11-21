package com.javarush.test.level14.lesson06.home01;

/**
 * Created by talismanov on 15.11.16.
 */
public abstract class Hen {
    abstract int getCountOfEggsPerMonth();

    String getDescription() {
        return "Я курица.";
    }
}
