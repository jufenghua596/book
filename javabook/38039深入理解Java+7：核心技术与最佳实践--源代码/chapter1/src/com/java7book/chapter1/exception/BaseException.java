package com.java7book.chapter1.exception; 

public class BaseException extends Exception {

    public BaseException() {
    }

    public BaseException(String msg) {
        super(msg);
    }

    public BaseException(Throwable cause) {
        super(cause);
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }
}
