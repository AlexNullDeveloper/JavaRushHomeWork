package com.javarush.test.level28.lesson15.big01;

import com.javarush.test.level28.lesson15.big01.model.Provider;

import java.util.Arrays;


/**
 * Created by Александр on 10.12.2016.
 */
public class Controller {
    private Provider[] providers;

    public Controller(Provider... providers) {
        if (providers.length < 1) {
            throw new IllegalArgumentException();
        }
        this.providers = providers;
    }

    @Override
    public String toString() {
        return "Controller{" +
                "providers=" + Arrays.toString(providers) +
                '}';
    }
}
