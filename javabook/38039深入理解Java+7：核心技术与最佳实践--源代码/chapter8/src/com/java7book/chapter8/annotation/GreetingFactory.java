package com.java7book.chapter8.annotation;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@SupportedGreetingLocales({"en", "zh_CN"})
public class GreetingFactory {
    private static Map<Locale, Class<? extends Greeting>> impls = new HashMap<>();
    public static void register(Locale locale, Class<? extends Greeting> clazz) {
        impls.put(locale, clazz);
    }
    public static String greet(Locale locale) {
        if (!impls.containsKey(locale)) {
            return null;
        }
        Class<? extends Greeting> clazz = impls.get(locale);
        try {
            Greeting instance = clazz.newInstance();
            return instance.greet();
        } catch (Exception e) {
           return null;
        }
    }
}
