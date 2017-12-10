package com.java7book.chapter12;

public class ObjectHolderUsage {
    public void use() {
        ObjectHolder<String> holder = new ObjectHolder<String>();
        holder.setObject("Hello");
        String str = holder.getObject();
    }
}
