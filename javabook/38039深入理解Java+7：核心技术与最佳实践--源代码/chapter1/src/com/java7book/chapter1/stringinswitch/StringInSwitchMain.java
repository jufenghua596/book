package com.java7book.chapter1.stringinswitch;

public class StringInSwitchMain {

    public static void main(String[] args) {
        Title salutation = new Title();
        System.out.println(salutation.generate("张三", "男"));
        System.out.println(salutation.generate("李四", "女"));
        System.out.println(salutation.generate("王五", "未知"));
        System.out.println(salutation.generate("赵六", null));
    }
}
