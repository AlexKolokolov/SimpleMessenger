package ua.djhans;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Класс содержит статический метод выдающий сообщение, которое зависит от переданных методу
 * значения часа (от 0 до 23) и локали пользователя.
 */

public class Messenger {
    private static Logger logger = LogManager.getLogger(Messenger.class);

    public static String getMessage(int currentHour, Locale locale) {
        logger.debug("---getMessage() method begin---");
        logger.debug("Got current hour: " + currentHour);
        logger.debug("Got current locale: " + locale);

        locale = locale == null || !"ru".equals(locale.getLanguage()) ? Locale.ENGLISH : locale;
        currentHour = currentHour > 23 || currentHour < 0 ? 0 : currentHour;

        logger.debug("Current hour after validation: " + currentHour);
        logger.debug("Locale after validation: " + locale);

        ResourceBundle bundle = ResourceBundle.getBundle("Messages", locale);
        String timeOfDay = "";

        if (currentHour >= 6 && currentHour < 9) timeOfDay = "morning";
        if (currentHour >= 9 && currentHour < 19) timeOfDay = "day";
        if (currentHour >= 19 && currentHour < 23) timeOfDay = "evening";
        if (currentHour >= 23 || currentHour < 6) timeOfDay = "night";

        logger.debug("Time of day: " + timeOfDay);

        String message = bundle.getString(timeOfDay);

        logger.debug("Message to return: " + message);
        logger.debug("----getMessage() method end----\n\r");

        return message;
    }

    public static void main(String[] args) {
        int currentHour = new GregorianCalendar().get(Calendar.HOUR_OF_DAY);
        Locale locale = Locale.getDefault();

        System.out.println(getMessage(currentHour, locale));
    }
}
