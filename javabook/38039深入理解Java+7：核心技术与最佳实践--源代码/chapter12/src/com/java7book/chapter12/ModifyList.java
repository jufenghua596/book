package com.java7book.chapter12;

import java.util.ArrayList;
import java.util.List;

public class ModifyList {
    public void modify(ArrayList<Number> list) {
        list.add(1.0f);
    }
    public void changeList() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(3);
        //modify(list);
        Integer value = list.get(1);
    }
}
