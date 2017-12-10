package com.java7book.chapter10;
 
class A {
    static int value = 100;
    
    static {
        System.out.println("类A初始化。");
    }
}

class B extends A {
    static {
        System.out.println("类B初始化。");
    }
}

public class StaticFieldInit {
    public static void main(String[] args) {
        System.out.println(B.value);
    }
}
