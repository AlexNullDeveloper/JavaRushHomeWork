package com.javarush.test.level15.lesson12.home04;

/**
 * Created by Александр on 20.11.2016.
 */
public class Earth implements Planet {
    private static Earth earth;

    private Earth() {

    }

    public static Earth getInstance() {

        if (earth == null) {
            synchronized (Earth.class) {
                if (earth == null) {
                    earth = new Earth();
                }
            }
        }

        return earth;
    }
}
