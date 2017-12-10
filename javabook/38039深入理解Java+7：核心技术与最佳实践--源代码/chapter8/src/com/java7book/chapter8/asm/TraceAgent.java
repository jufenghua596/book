package com.java7book.chapter8.asm;

import java.lang.instrument.Instrumentation;

public class TraceAgent {
    public static void premain(String args, Instrumentation inst) {
        inst.addTransformer(new TraceTransformer());
    } 
}
