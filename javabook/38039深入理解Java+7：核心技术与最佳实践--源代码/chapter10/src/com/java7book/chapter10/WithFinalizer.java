package com.java7book.chapter10;

public class WithFinalizer {
    private final Object guardian = new Object() {
        protected void finalize() throws Throwable {
            super.finalize();
        }
    };
}
