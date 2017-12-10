package com.java7book.chapter12;

public class SampleClass<S extends T, T> {
    public void test() {
        SampleClass<String, Comparable<String>> obj = new SampleClass<>();
    }
}
