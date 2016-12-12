package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Александр on 10.12.2016.
 */
public class HHStrategy implements Strategy {
    private static final String URL_FORMAT = "http://hh.ua/search/vacancy?text=java+%s&page=%d";

    @Override
    public List<Vacancy> getVacancies(String searchString) {
        List<Vacancy> list = new ArrayList<>();
        int page = 0;
        Document document;
        try {
            while (true) {
                String url = String.format(URL_FORMAT, searchString, 2);
                document = getDocument(searchString, page);
//                    Jsoup
//                    .connect(url)
//                    .referrer("https://hh.ua/search/vacancy?text=java+%D0%BA%D0%B8%D0%B5%D0%B2")
//                    .userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36")
//                    .get();
//            String html = document.html();
                Elements elements = document.select("[data-qa=vacancy-serp__vacancy]");
                System.out.println("elements.size()" + elements.size());

                for (Element element : elements) {
                    // title
                    Element titleElement = element.select("[data-qa=vacancy-serp__vacancy-title]").first();
                    String title = titleElement.text();

                    // salary
                    Element salaryElement = element.select("[data-qa=vacancy-serp__vacancy-compensation]").first();
                    String salary = "";
                    if (salaryElement != null) {
                        salary = salaryElement.text();
                    }

                    // city
                    String city = element.select("[data-qa=vacancy-serp__vacancy-address]").first().text();

                    // company
                    String companyName = element.select("[data-qa=vacancy-serp__vacancy-employer]").first().text();

                    // site
                    String siteName = "http://hh.ua/";

                    // url
                    String myUrl = titleElement.attr("href");


                    // add vacancy to the list
                    Vacancy vacancy = new Vacancy();
                    vacancy.setTitle(title);
                    vacancy.setSalary(salary);
                    vacancy.setCity(city);
                    vacancy.setCompanyName(companyName);
                    vacancy.setSiteName(siteName);
                    vacancy.setUrl(myUrl);
                    list.add(vacancy);
                }
                break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }

    public Document getDocument(String searchString, int page) throws IOException {
        Document document = Jsoup.connect("http://javarush.ru/testdata/big28data.html").get();

        return document;
    }

}
