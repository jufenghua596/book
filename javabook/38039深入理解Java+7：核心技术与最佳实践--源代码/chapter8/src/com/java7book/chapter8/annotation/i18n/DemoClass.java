package com.java7book.chapter8.annotation.i18n;

@MessageBundle("Messages")
public class DemoClass {
    public void output() {
        System.out.println(getTestMessage("Hello"));
    }
    
    @Message(key = "OUTPUT_MESSAGE", value = "This is a sample message.")
    public String getOutputMessage(Object... args) {
        return "";
    }
    
    @Message(key = "TEST_MESSAGE", value = "This is test message. %1$s")
    public String getTestMessage(Object... args) {
        return "";
    }
}
