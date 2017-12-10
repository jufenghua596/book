package com.java7book.chapter12;

import java.util.ArrayList;
import java.util.List;

public class Varargs {
    public void varargsMethod(List<String>... values) {
        Object[] array = values;
        List<Integer> list = (List<Integer>) array[0];
        list.add(1);
    }
    
    @SuppressWarnings("unchecked")
    public void useVarargsMethod() {
        List<String> list = new ArrayList<>();
        list.add("Hello");
        varargsMethod(list);
        String str = list.get(1); //抛出ClassCastException异常
    }
    
    public static void main(String[] args) {
        Varargs varargs = new Varargs();
        varargs.useVarargsMethod();
    }
}
