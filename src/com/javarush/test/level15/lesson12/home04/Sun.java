package com.javarush.test.level15.lesson12.home04;

/**
 * Created by Александр on 20.11.2016.
 */
public class Sun implements Planet  {
    private static Sun sun;

    private Sun() {

    }

    public static Sun getInstance() {
        if (sun == null) {
            synchronized (Sun.class) {
                if (sun == null) {
                    sun = new Sun();
                }
            }
        }
        return sun;
    }
}
