package ua.djhans;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Класс содержит статический метод выдающий сообщение, которое зависит от переданных методу
 * значения часа (от 0 до 23) и локали пользователя.
 */

public class Messenger {
    public static String getMessage(int currentHour, Locale locale) {

        locale = locale == null || !"ru".equals(locale.getLanguage()) ? Locale.ENGLISH : locale;

        ResourceBundle bundle = ResourceBundle.getBundle("Messages", locale);
        String timeOfDay = "";

        if (currentHour >= 6 && currentHour < 9) timeOfDay = "morning";
        if (currentHour >= 9 && currentHour < 19) timeOfDay = "day";
        if (currentHour >= 19 && currentHour < 23) timeOfDay = "evening";
        if (currentHour >= 23 || currentHour < 6) timeOfDay = "night";

        return bundle.getString(timeOfDay);
    }

    public static void main(String[] args) {

        int currentHour = new GregorianCalendar().get(Calendar.HOUR_OF_DAY);
        Locale locale = Locale.getDefault();

        System.out.println(getMessage(currentHour, locale));

    }
}
