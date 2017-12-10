/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter4.format;

import java.math.RoundingMode;
import java.text.ChoiceFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

/**
 *
 * @author chengfu
 */
public class UseNumberFormat {

    public void formatAndParseNumber() throws ParseException {
        NumberFormat format = NumberFormat.getNumberInstance();
        double num = 100.5;
        format.setMinimumFractionDigits(3);
        format.setMinimumIntegerDigits(5);
        format.format(num); //值为00,100.500
        String numStr = "523.34";
        format.setParseIntegerOnly(true);
        format.parse(numStr); //值为523
    }
    
    public void useDecimalFormat() {
        NumberFormat format = NumberFormat.getNumberInstance();
        DecimalFormat df = null;
        if (format instanceof DecimalFormat) {
            df = (DecimalFormat) format;
        }
        else {
            df = new DecimalFormat();
        }
        df.applyPattern("000.###");
        System.out.println(df.format(3.14));
    }
    
    public void formatCurrency() {
        NumberFormat format = NumberFormat.getCurrencyInstance();
        System.out.println(format.format(33.45));
    }
    
    public void useChoiceFormat() {
       ChoiceFormat format = new ChoiceFormat(new double[] {0, 1, ChoiceFormat.nextDouble(1)}, 
               new String[] {"no people", "person", "people"});
       int count = 2;
       String msg = count + " " + format.format(count); //值为2 people
       System.out.println(msg);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        UseNumberFormat unf = new UseNumberFormat();
        unf.formatAndParseNumber();
        unf.useDecimalFormat();
        unf.formatCurrency();
        unf.useChoiceFormat();
    }
}
