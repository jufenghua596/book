/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter2.scripting;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.script.Compilable;
import javax.script.CompiledScript;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 *
 * @author chengfu
 */
public class ScriptCompile extends JsScriptRunner {
    public CompiledScript compile(String scriptText) throws ScriptException {
        ScriptEngine engine = getJavaScriptEngine();
        if (engine instanceof Compilable) {
            CompiledScript script = ((Compilable) engine).compile(scriptText);
            return script;
        }
        return null;
    }
    
    public void run(String scriptText) throws ScriptException {
        CompiledScript script = compile(scriptText);
        if (script == null) {
            return;
        }
        for (int i = 0; i < 100; i++) {
            script.eval();
        }
    }

    public static void main(String[] args) {
        ScriptCompile sc = new ScriptCompile();
        try {
            sc.run("println('Hello');");
        } catch (ScriptException ex) {
            Logger.getLogger(ScriptCompile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
