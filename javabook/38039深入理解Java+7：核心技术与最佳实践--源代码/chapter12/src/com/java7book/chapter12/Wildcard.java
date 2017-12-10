package com.java7book.chapter12;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Wildcard {
    public List<? extends Number> createList() {
        return new ArrayList<>();
    }
    
    public void use() {
        List<? extends Serializable> list = createList();
    }
}
