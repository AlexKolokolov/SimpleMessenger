package ua.djhans;

import org.junit.Assert;
import org.junit.Test;

import java.util.Locale;

/**
 * Created by Administrator on 19.01.2016.
 */
public class MessengerTest {

    @Test
    public void getMessageTestRuNight() {
        Locale locale = new Locale("ru", "RU");
        int hourOfDay = 4;
        String message = Messenger.getMessage(hourOfDay, locale);
        Assert.assertEquals("Доброй ночи, Мир!", message);
    }

    @Test
    public void getMessageTestRuDay() {
        Locale locale = new Locale("ru", "RU");
        int hourOfDay = 12;
        String message = Messenger.getMessage(hourOfDay, locale);
        Assert.assertEquals("Добрый день, Мир!", message);
    }

    @Test
    public void getMessageTestEnNight() {
        Locale locale = Locale.ENGLISH;
        int hourOfDay = 4;
        String message = Messenger.getMessage(hourOfDay, locale);
        Assert.assertEquals("Good night, World!", message);
    }

    @Test
    public void getMessageTestEnDay() {
        Locale locale = Locale.ENGLISH;
        int hourOfDay = 12;
        String message = Messenger.getMessage(hourOfDay, locale);
        Assert.assertEquals("Good day, World!", message);
    }
}
