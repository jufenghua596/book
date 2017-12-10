package com.java7book.chapter1.exception;

/**
 *
 * @author chengfu
 */
public class DisappearedException {
    public void show() throws BaseException{
        try {
            Integer.parseInt("Hello");
        }
        catch (NumberFormatException nfe) {
            throw new BaseException(nfe);
        } finally {
            try {
                int result = 2 / 0;
            } catch (ArithmeticException ae) {
                throw new BaseException(ae);
            }
        }
    }
}
