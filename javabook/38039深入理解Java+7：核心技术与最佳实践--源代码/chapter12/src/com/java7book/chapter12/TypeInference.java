package com.java7book.chapter12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TypeInference {
    public <T> T method(T obj) {
        return obj;
    }
    
    public <T> List<T> createList() {
        return new ArrayList<T>();
    }
    
    public static void main(String[] args) {
        TypeInference typeInference = new TypeInference();
        typeInference.method("Hello");
        List<Object> list1 = typeInference.method(typeInference.createList());
        List<Integer> list2 = typeInference.createList();
        List<Integer> list3 = typeInference.method(list2);
        
        List<String> list = new ArrayList<>();
        Map<List<? extends Number>, Map<String, Long>> map = new HashMap<>();
    }
}
