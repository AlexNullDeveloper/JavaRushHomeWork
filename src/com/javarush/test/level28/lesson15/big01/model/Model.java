package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.view.View;
import com.javarush.test.level28.lesson15.big01.vo.Vacancy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Александр on 12.12.2016.
 */
public class Model {
    View view;
    Provider[] providers;

    public Model(View view, Provider[] providers) {
        if (view == null || providers == null || providers.length == 0) {
            throw new IllegalArgumentException();
        }
        this.view = view;
        this.providers = providers;
    }


    public  void selectCity(String city) {
        List<Vacancy> allVacancies = new ArrayList<>();
        for (int i = 0; i < providers.length; i++) {
            List<Vacancy> javaVacancies = providers[i].getJavaVacancies("");
            allVacancies.addAll(javaVacancies);
        }
        view.update(allVacancies);
    }
}
