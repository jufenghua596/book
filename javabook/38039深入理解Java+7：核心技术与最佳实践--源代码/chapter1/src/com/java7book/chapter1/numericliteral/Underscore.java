package com.java7book.chapter1.numericliteral;

import static java.lang.System.out;
public class Underscore {
    public void display() {
        out.println(1_500_000); //输出1500000
        double value1 = 5_6.3_4;
        int value2 = 89_3___1;
        out.println(value1); //输出56.34
        out.println(value2); //输出8931
    }
}
