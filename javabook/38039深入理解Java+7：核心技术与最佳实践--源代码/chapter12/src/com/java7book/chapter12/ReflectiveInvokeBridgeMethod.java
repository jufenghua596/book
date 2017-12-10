package com.java7book.chapter12;

import java.lang.reflect.Method;

public class ReflectiveInvokeBridgeMethod {
    public void invoke() {
        try {
            Method method = Sequence.class.getMethod("compareTo", new Class<?>[] {Object.class});
            method.isBridge(); //true
            Sequence seq1 = new Sequence(1);
            Sequence seq2 = new Sequence(2);
            Object obj = method.invoke(seq1, seq2);
            System.out.println(obj);
            method.invoke(seq1, "Hello");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        ReflectiveInvokeBridgeMethod ribm = new ReflectiveInvokeBridgeMethod();
        ribm.invoke();
    }
}
