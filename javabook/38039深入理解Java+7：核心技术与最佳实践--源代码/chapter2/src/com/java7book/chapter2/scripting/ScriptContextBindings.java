/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter2.scripting;

import javax.script.Bindings;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

/**
 *
 * @author chengfu
 */
public class ScriptContextBindings extends JsScriptRunner {
    
    public void scriptContextBindings() throws ScriptException {
        ScriptEngine engine = getJavaScriptEngine();
        ScriptContext context = engine.getContext();
        Bindings bindings1 = engine.createBindings();
        bindings1.put("name", "Alex");
        context.setBindings(bindings1, ScriptContext.GLOBAL_SCOPE);
        Bindings bindings2 = engine.createBindings();
        bindings2.put("name", "Bob");
        context.setBindings(bindings2, ScriptContext.ENGINE_SCOPE);
        engine.eval("println(name);");
    }
    
    public void useScriptContextValues() throws ScriptException {
    	ScriptEngine engine = getJavaScriptEngine();
        ScriptContext context = engine.getContext();
        Bindings bindings = context.getBindings(ScriptContext.ENGINE_SCOPE);
        bindings.put("name", "Alex");
        engine.eval("println(name);");
    }
    
    public void attributeInBindings() throws ScriptException {
    	ScriptEngine engine = getJavaScriptEngine();
    	ScriptContext context = engine.getContext();
    	context.setAttribute("name", "Alex", ScriptContext.GLOBAL_SCOPE);
    	engine.eval("println(name);");
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ScriptException {
        ScriptContextBindings scb = new ScriptContextBindings();
        scb.scriptContextBindings();
        scb.useScriptContextValues();
        scb.attributeInBindings();
    }
}
