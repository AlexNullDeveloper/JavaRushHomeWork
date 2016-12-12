package com.javarush.test.level28.lesson15.big01;

import com.javarush.test.level28.lesson15.big01.model.HHStrategy;
import com.javarush.test.level28.lesson15.big01.model.Model;
import com.javarush.test.level28.lesson15.big01.model.Provider;
import com.javarush.test.level28.lesson15.big01.view.HtmlView;
import com.javarush.test.level28.lesson15.big01.view.View;

/**
 * Created by Александр on 10.12.2016.
 */
public class Aggregator {
    /*3. Для запуска нужно еще обновить метод main в Aggregator.
3.1. Создай вью, модель, контроллер.
3.2. Засэть во вью контроллер.
3.3. Вызови у вью метод  userCitySelectEmulationMethod.

4. Запускай приложение! Подожди несколько секунд, чтобы выгреблись данные.
Работает? Отлично, что работает!
*/
    public static void main(String[] args) {
        View view = new HtmlView();
        Provider provider = new Provider(new HHStrategy());
        Provider[] providers = new Provider[]{provider};
        Model model = new Model(view, providers);
        Controller controller = new Controller(model);
        view.setController(controller);
        view.userCitySelectEmulationMethod();
    }
}
