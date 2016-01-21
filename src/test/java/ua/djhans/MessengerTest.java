package ua.djhans;

import org.junit.Assert;
import org.junit.Test;

import java.util.Locale;

/**
 * Класс содержит юнит-тесты для метода getMessage(int hour, Locale locale) класса Messenger.
 */
public class MessengerTest {

    private void getMessageTestRu(int hourOfDay) {
        String message = Messenger.getMessage(hourOfDay, new Locale("ru"));
        if (hourOfDay >= 6 && hourOfDay < 9) Assert.assertEquals("Доброе утро, Мир!", message);
        if (hourOfDay >= 9 && hourOfDay < 19) Assert.assertEquals("Добрый день, Мир!", message);
        if (hourOfDay >= 19 && hourOfDay < 23) Assert.assertEquals("Добрый вечер, Мир!", message);
        if (hourOfDay >= 23 || hourOfDay < 6) Assert.assertEquals("Спокойной ночи, Мир!", message);
    }

    private void getMessageTestNotRu(int hourOfDay, Locale notRussianLocale) {
        String message = Messenger.getMessage(hourOfDay, notRussianLocale);
        if (hourOfDay >= 6 && hourOfDay < 9) Assert.assertEquals("Good morning, World!", message);
        if (hourOfDay >= 9 && hourOfDay < 19) Assert.assertEquals("Good day, World!", message);
        if (hourOfDay >= 19 && hourOfDay < 23) Assert.assertEquals("Good evening, World!", message);
        if (hourOfDay >= 23 || hourOfDay < 6) Assert.assertEquals("Good night, World!", message);
    }

    @Test
    public void testRu0h() {
        getMessageTestRu(0);
    }

    @Test
    public void testRu2h() {
        getMessageTestRu(2);
    }

    @Test
    public void testRu6h() {
        getMessageTestRu(6);
    }

    @Test
    public void testRu8h() {
        getMessageTestRu(8);
    }

    @Test
    public void testRu9h() {
        getMessageTestRu(9);
    }

    @Test
    public void testRu12h() {
        getMessageTestRu(12);
    }

    @Test
    public void testRu18h() {
        getMessageTestRu(18);
    }

    @Test
    public void testRu19h() {
        getMessageTestRu(19);
    }

    @Test
    public void testRu21h() {
        getMessageTestRu(21);
    }

    @Test
    public void testRu23h() {
        getMessageTestRu(0);
    }

    @Test
    public void testRuWrongTime1() {
        getMessageTestRu(50);
    }

    @Test
    public void testRuWrongTime2() {
        getMessageTestRu(-50);
    }

    @Test
    public void testEn0h() {
        getMessageTestNotRu(0, Locale.ENGLISH);
    }

    @Test
    public void testEn4h() {
        getMessageTestNotRu(4, Locale.ENGLISH);
    }

    @Test
    public void testEn6h() {
        getMessageTestNotRu(6, Locale.ENGLISH);
    }

    @Test
    public void testEn9h() {
        getMessageTestNotRu(9, Locale.ENGLISH);
    }

    @Test
    public void testEn13h() {
        getMessageTestNotRu(13, Locale.ENGLISH);
    }

    @Test
    public void testEn17h() {
        getMessageTestNotRu(17, Locale.ENGLISH);
    }

    @Test
    public void testEn19h() {
        getMessageTestNotRu(19, Locale.ENGLISH);
    }

    @Test
    public void testEn23h() {
        getMessageTestNotRu(23, Locale.ENGLISH);
    }

    @Test
    public void testEnWrongTime1() {
        getMessageTestNotRu(100, Locale.ENGLISH);
    }

    @Test
    public void testEnWrongTime2() {
        getMessageTestNotRu(-100, Locale.ENGLISH);
    }

    @Test
    public void testGe0h() {
        getMessageTestNotRu(0, Locale.GERMAN);
    }

    @Test
    public void testGe6h() {
        getMessageTestNotRu(0, Locale.GERMAN);
    }

    @Test
    public void testGe19h() {
        getMessageTestNotRu(19, Locale.GERMAN);
    }

    @Test
    public void testGeWrongTime() {
        getMessageTestNotRu(1000, Locale.GERMAN);
    }

    @Test
    public void testFr8h() {
        getMessageTestNotRu(8, Locale.FRENCH);
    }

    @Test
    public void testFr19h() {
        getMessageTestNotRu(19, Locale.FRENCH);
    }

    @Test
    public void testUnknownLang9h() {
        getMessageTestNotRu(9, null);
    }

    @Test
    public void testUnknownLang19h() {
        getMessageTestNotRu(19, null);
    }

    @Test
    public void testUnknownLangWrongTime() {
        getMessageTestNotRu(-1000, null);
    }
}
