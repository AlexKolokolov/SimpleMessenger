package ua.djhans;

import org.junit.Assert;
import org.junit.Test;

import java.util.Locale;

/**
 * Created by Administrator on 19.01.2016.
 */
public class MessengerTest {

    @Test
    public void getMessageTestRu4() {
        Locale locale = new Locale("ru", "RU");
        int hourOfDay = 4;
        String message = Messenger.getMessage(hourOfDay, locale);
        Assert.assertEquals("Доброй ночи, Мир!", message);
    }

    @Test
    public void getMessageTestRu6() {
        Locale locale = new Locale("ru", "RU");
        int hourOfDay = 6;
        String message = Messenger.getMessage(hourOfDay, locale);
        Assert.assertEquals("Доброе утро, Мир!", message);
    }

    @Test
    public void getMessageTestRu12() {
        Locale locale = new Locale("ru", "RU");
        int hourOfDay = 12;
        String message = Messenger.getMessage(hourOfDay, locale);
        Assert.assertEquals("Добрый день, Мир!", message);
    }

    @Test
    public void getMessageTestEn8() {
        Locale locale = Locale.ENGLISH;
        int hourOfDay = 8;
        String message = Messenger.getMessage(hourOfDay, locale);
        Assert.assertEquals("Good morning, World!", message);
    }

    @Test
    public void getMessageTestEn22() {
        Locale locale = Locale.ENGLISH;
        int hourOfDay = 22;
        String message = Messenger.getMessage(hourOfDay, locale);
        Assert.assertEquals("Good evening, World!", message);
    }

    @Test
    public void getMessageTestDe7() {
        Locale locale = Locale.GERMAN;
        int hourOfDay = 7;
        String message = Messenger.getMessage(hourOfDay, locale);
        Assert.assertEquals("Good morning, World!", message);
    }

    @Test
    public void getMessageTestDe19() {
        Locale locale = Locale.GERMAN;
        int hourOfDay = 19;
        String message = Messenger.getMessage(hourOfDay, locale);
        Assert.assertEquals("Good evening, World!", message);
    }

    @Test
    public void getMessageTestUnknown8() {
        Locale locale = null;
        int hourOfDay = 8;
        String message = Messenger.getMessage(hourOfDay, locale);
        Assert.assertEquals("Good morning, World!", message);
    }

    @Test
    public void getMessageTestUnknown20() {
        Locale locale = null;
        int hourOfDay = 20;
        String message = Messenger.getMessage(hourOfDay, locale);
        Assert.assertEquals("Good evening, World!", message);
    }

    @Test
    public void getMessageTestRuWrongTime() {
        Locale locale = new Locale("ru", "RU");
        int hourOfDay = -5;
        String message = Messenger.getMessage(hourOfDay, locale);
        Assert.assertEquals("Доброй ночи, Мир!", message);
    }

    @Test
    public void getMessageTestUnknownWrongTime() {
        Locale locale = null;
        int hourOfDay = 50;
        String message = Messenger.getMessage(hourOfDay, locale);
        Assert.assertEquals("Good night, World!", message);
    }
}
