package com.java7book.chapter8.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.SOURCE)
@Inherited
public @interface Author {
    String name();
    String email();
    boolean enableEmailNotification() default true;
}
