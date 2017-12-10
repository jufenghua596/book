/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter2.scripting;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

/**
 *
 * @author chengfu
 */
public abstract class JsScriptRunner {
     protected ScriptEngine getJavaScriptEngine() {
        ScriptEngineManager manager = new ScriptEngineManager();
        //ScriptEngine engine = manager.getEngineByName("JavaScript");
        //ScriptEngine engine = manager.getEngineByExtension("js");
        ScriptEngine engine = manager.getEngineByMimeType("text/javascript");
        if (engine == null) {
            throw new RuntimeException("找不到JavaScript语言执行引擎。");
        }
        return engine;
    }
}
