package com.java7book.chapter8.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
public @interface WithArrayValue {
    String name();
    Class<?>[] appliedTo();
}
