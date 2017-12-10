/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter1.varargs;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author chengfu
 */
public class VarargsWarning {

    public static void main(String[] args) {

        System.out.println(new VarargsWarning().sum(1, 2, 3));
        Pair result = VarargsWarning.sumF(new Pair(0, 0), new Pair(2, 4), new Pair(5, 6));
        System.out.println(result);

        VarargsWarning.useVarargs(new ArrayList<String>());
    }

    @SafeVarargs
    public static <T> T useVarargs(T... args) {
        return args.length > 0 ? args[0] : null;
    }
    
    public int sum(int... args) {
        int result = 0;
        for (int value : args) {
            result += value;
        }
        return result;
    }

    public static <T extends Addable> T sumF(T initial, T... args) {
        T result = initial;
        for (T value : args) {
            result.add(value);
        }
        return result;
    }

    private static interface Addable<T> {

        void add(T operand);
    }

    private static class Pair implements Addable<Pair> {

        private int x;
        private int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public void add(Pair operand) {
            this.x += operand.x;
            this.y += operand.y;
        }

        public String toString() {
            return "Pair{" + "x=" + x + ", y=" + y + '}';
        }
    }
}
