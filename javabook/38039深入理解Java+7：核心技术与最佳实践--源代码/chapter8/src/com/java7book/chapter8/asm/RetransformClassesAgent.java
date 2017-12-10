package com.java7book.chapter8.asm;

import java.lang.instrument.Instrumentation;
import java.lang.instrument.UnmodifiableClassException;

public class RetransformClassesAgent {
    static Instrumentation instrumentation;
    static TraceTransformer traceTransformer = new TraceTransformer();
    public static void premain(String args, Instrumentation inst) {
        instrumentation = inst;
    }
    
    public static void enableTrace() {
        if (instrumentation.isRetransformClassesSupported()) {
            instrumentation.addTransformer(traceTransformer, true);
            try {
                instrumentation.retransformClasses(ToBeTraced.class);
            } catch (UnmodifiableClassException e) {
                e.printStackTrace();
            }
        }
    }
    
    public static void disableTrace() {
        if (instrumentation.isRetransformClassesSupported()) {
            instrumentation.removeTransformer(traceTransformer);
            try {
                instrumentation.retransformClasses(ToBeTraced.class);
            } catch (UnmodifiableClassException e) {
                e.printStackTrace();
            }
        }
    }
}
