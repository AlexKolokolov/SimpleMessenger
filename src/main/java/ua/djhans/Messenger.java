package ua.djhans;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Класс для генерации сообщений-приветствий.
 * Содержит статический метод выдающий сообщение, которое зависит от переданных методу
 * значения часа (в формате от 0 до 23) и локали. Если язык системы - русский, то сообщения
 * выводятся на русском, иначе - на английском.
 * Промежуточные данные при работе метода записываются в лог-файл messenger.log,
 * который создается в корневой папке проекта.
 */
public class Messenger {
    private static Logger logger = LogManager.getLogger(Messenger.class);

    public static String getMessage(int hour, Locale locale) {
        logger.debug("---getMessage() method begin---");

        logger.debug("Got current hour: " + hour);
        String timeOfDay = getTimeOfDay(hour);
        logger.debug("Current time of day: " + timeOfDay);

        logger.debug("Got user's locale: " + locale);
        locale = locale == null || !"ru".equals(locale.getLanguage()) ? Locale.ENGLISH : locale;
        logger.debug("Locale after validation: " + locale);

        ResourceBundle bundle = ResourceBundle.getBundle("Messages", locale);
        String message = bundle.getString(timeOfDay);
        logger.debug("Returned message: " + message);
        logger.debug("----getMessage() method end----\n\r");

        return message;
    }

    private static String getTimeOfDay(int hour) {
        logger.debug("--getTimeOfDay() method begin--");
        String timeOfDay = "";
        if (hour >= 6 && hour < 9) timeOfDay = "morning";
        if (hour >= 9 && hour < 19) timeOfDay = "day";
        if (hour >= 19 && hour < 23) timeOfDay = "evening";
        if (hour >= 23 || hour < 6) timeOfDay = "night";
        logger.debug("---getTimeOfDay() method end---");
        return timeOfDay;
    }

    public static void printCurrentTimeMessage() {
        int currentHour = new GregorianCalendar().get(Calendar.HOUR_OF_DAY);
        Locale userLocale = Locale.getDefault();
        System.out.println(getMessage(currentHour, userLocale));
    }

    public static void main(String[] args) {
        printCurrentTimeMessage();
    }
}
