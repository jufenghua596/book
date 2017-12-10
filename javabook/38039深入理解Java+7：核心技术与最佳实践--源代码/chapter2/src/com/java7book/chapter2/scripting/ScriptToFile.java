/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter2.scripting;

import java.io.IOException;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import java.io.FileWriter;
import javax.script.ScriptException;

/**
 *
 * @author chengfu
 */
public class ScriptToFile extends JsScriptRunner {
    
    public void scriptToFile() throws IOException, ScriptException {
        ScriptEngine engine = getJavaScriptEngine();
        ScriptContext context = engine.getContext();
        context.setWriter(new FileWriter("output.txt"));
        engine.eval("println('Hello World!');");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, ScriptException {
        new ScriptToFile().scriptToFile();
    }
}
