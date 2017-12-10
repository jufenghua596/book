package com.java7book.chapter1.exception;

import java.math.BigDecimal;

/**
 *
 * @author chengfu
 */
public class ExceptionMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DisappearedException disappearedException = new DisappearedException();
        try {
            disappearedException.show();
        } catch (BaseException ex) {
            System.out.println(ex.getCause());
        }
        
        ReadFile readFile = new ReadFile();
        try {
            readFile.read("C:\\my.txt");
        } catch (BaseException ex) {
            System.out.println(ex.getCause().getMessage());
        }
        
        System.out.println(new InsufficientBalanceException(new BigDecimal(10.5), new BigDecimal(3.2)));
    }
}
