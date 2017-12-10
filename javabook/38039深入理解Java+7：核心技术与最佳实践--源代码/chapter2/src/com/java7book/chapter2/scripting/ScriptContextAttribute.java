/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter2.scripting;

import javax.script.ScriptContext;
import javax.script.ScriptEngine;

/**
 *
 * @author chengfu
 */
public class ScriptContextAttribute extends JsScriptRunner {
    
    public void scriptContextAttribute() {
    	ScriptEngine engine = getJavaScriptEngine();
        ScriptContext context = engine.getContext();
        context.setAttribute("name", "Alex", ScriptContext.GLOBAL_SCOPE);
        context.setAttribute("name", "Bob", ScriptContext.ENGINE_SCOPE);
        context.getAttribute("name"); //值为Bob
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new ScriptContextAttribute().scriptContextAttribute();
    }
}
