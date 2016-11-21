package com.javarush.test.level14.lesson08.bonus03;

/**
 * Created by talismanov on 17.11.16.
 */
public class Singleton {
    private static volatile Singleton singleton;

    private Singleton() {}

    public static Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    System.out.println("creates singleton");
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
