/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter2.scripting;

import javax.script.Bindings;
import javax.script.SimpleBindings;

/**
 *
 * @author chengfu
 */
public class GameConfig {
    public int screenWidth;
    
    public int screenHeight;
    
    private Bindings bindings = new SimpleBindings();
    
    public GameConfig() {
        this.initBindings();
    }

    private void initBindings() {
        bindings.put("config", this);
    }
    
    public Bindings getScriptBindings() {
        return bindings;
    }
    
    public int getScreenWidth() {
        return screenWidth;
    }
}
