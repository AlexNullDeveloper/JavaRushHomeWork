package com.javarush.test.level28.lesson15.big01.view;

import com.javarush.test.level28.lesson15.big01.Controller;
import com.javarush.test.level28.lesson15.big01.vo.Vacancy;

import java.util.List;

/**
 * Created by Александр on 12.12.2016.
 */
public interface View {
    void update(List<Vacancy> vacancies);
    void setController(Controller controller);
    void userCitySelectEmulationMethod();
}
