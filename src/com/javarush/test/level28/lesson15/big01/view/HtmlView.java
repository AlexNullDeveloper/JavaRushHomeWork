package com.javarush.test.level28.lesson15.big01.view;

import com.javarush.test.level28.lesson15.big01.Controller;
import com.javarush.test.level28.lesson15.big01.vo.Vacancy;

import java.util.Collections;
import java.util.List;

/**
 * Created by Александр on 12.12.2016.
 */
public class HtmlView implements View{
    private Controller controller;
    private final String filePath = "./src/" + this.getClass().getPackage().getName().replace('.', '/') + "/vacancies.html";

    @Override
    public void update(List<Vacancy> vacancies) {

        try {
            updateFile(getUpdatedFileContent(vacancies));
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(vacancies.size());
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void userCitySelectEmulationMethod() {
        controller.onCitySelect("Odessa");
    }

    private String getUpdatedFileContent(List<Vacancy> vacancyList){
        return "";
    }

    private void updateFile(String str) {

    }
}
