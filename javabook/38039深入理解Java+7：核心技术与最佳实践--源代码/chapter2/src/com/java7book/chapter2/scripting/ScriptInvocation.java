/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter2.scripting;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

/**
 *
 * @author chengfu
 */
public class ScriptInvocation extends JsScriptRunner {

    public void invokeFunction() throws ScriptException, NoSuchMethodException {
        ScriptEngine engine = getJavaScriptEngine();
        String scriptText = "function greet(name) { println('Hello, ' + name); } ";
        engine.eval(scriptText);
        Invocable invocable = (Invocable) engine;
        invocable.invokeFunction("greet", "Alex");
    }

    public void invokeMethod() throws ScriptException, NoSuchMethodException {
        ScriptEngine engine = getJavaScriptEngine();
        String scriptText = "var obj = { getGreeting : function(name) { return 'Hello, ' + name; } }; ";
        engine.eval(scriptText);
        Invocable invocable = (Invocable) engine;
        Object scope = engine.get("obj");
        Object result = invocable.invokeMethod(scope, "getGreeting", "Alex");
        System.out.println(result);
    }

    public void useInterface() throws ScriptException {
        ScriptEngine engine = getJavaScriptEngine();
        String scriptText = "function getGreeting(name) { return 'Hello, ' + name; } ";
        engine.eval(scriptText);
        Invocable invocable = (Invocable) engine;
        Greet greet = invocable.getInterface(Greet.class);
        System.out.println(greet.getGreeting("Alex"));
    }

    public static void main(String[] args) {
        ScriptInvocation si = new ScriptInvocation();
        try {
            si.invokeFunction();
            si.invokeMethod();
            si.useInterface();
        } catch (ScriptException ex) {
            Logger.getLogger(ScriptInvocation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(ScriptInvocation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
