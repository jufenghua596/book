/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter2.scripting;

import javax.script.ScriptException;

/**
 *
 * @author chengfu
 */
public class Game {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        GameConfig config = new GameConfig();
        GameConsole console = new GameConsole(config);
        Thread thread = new Thread(console);
        thread.start();
        thread.join();
    }
}
