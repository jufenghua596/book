package com.java7book.chapter4.demo;

import java.util.Locale;
import java.util.Locale.Category;

public class LocaleHolder {
    private static final InheritableThreadLocal<Locale> holder = new InheritableThreadLocal<Locale>() {
        protected Locale initialValue() {
            return Locale.getDefault(Category.DISPLAY);
        }
    };
    
    public static Locale get() {
        return holder.get();
    }
    public static void set(Locale locale) {
        holder.set(locale);
    }
}
