/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter2.scripting;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.script.Bindings;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.script.SimpleBindings;

/**
 *
 * @author chengfu
 */
public class BasicBinding extends JsScriptRunner {
    
    public void useDefaultBinding() throws ScriptException {
        ScriptEngine engine = getJavaScriptEngine();
        engine.put("name", "Alex");
        engine.eval("var message = 'Hello, ' + name;");
        engine.eval("println(message);");
        Object obj = engine.get("message");
        System.out.println(obj);
    }
    
    public void useCustomBinding() throws ScriptException {
        ScriptEngine engine = getJavaScriptEngine();
        Bindings bindings = new SimpleBindings();
        bindings.put("hobby", "playing games");
        engine.eval("println('I like ' + hobby);", bindings);
    }
    
    public static void main(String[] args) {
        try {
            BasicBinding bb = new BasicBinding();
            bb.useDefaultBinding();
            bb.useCustomBinding();
        } catch (ScriptException ex) {
            Logger.getLogger(BasicBinding.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
