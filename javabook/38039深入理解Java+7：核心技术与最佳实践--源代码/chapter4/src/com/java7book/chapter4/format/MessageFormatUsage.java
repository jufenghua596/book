/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter4.format;

import java.math.BigDecimal;
import java.text.MessageFormat;

/**
 *
 * @author chengfu
 */
public class MessageFormatUsage {
    
    public void formatWithNumber() {
        String pattern = "购买了{0,number,integer}件商品，单价为{1,number,currency}，合计：{2,number,\u00A4#,###.##}";
        MessageFormat format = new MessageFormat(pattern);
        int count = 3;
        double price = 1599.3;
        double total = price * count;
        format.format(new Object[] {count, price, total});
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MessageFormatUsage mfu = new MessageFormatUsage();
        mfu.formatWithNumber();
    }
}
