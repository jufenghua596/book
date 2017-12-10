/*
 * Copyright 2011 Cheng Fu
 */
package com.java7book.chapter4.format;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.util.Date;

/**
 *
 * @author chengfu
 */
public class DateTimeFormat {
    
    public void trackFormatPosition() {
        DateFormat format = DateFormat.getDateInstance(DateFormat.FULL);
        Date date = new Date();
        StringBuffer result = new StringBuffer();
        FieldPosition dayField = new FieldPosition(DateFormat.DAY_OF_WEEK_FIELD);
        format.format(date, result, dayField);
        String day = result.substring(dayField.getBeginIndex(), dayField.getEndIndex()); //值为星期几的本地化形式
    }
    
    public void parseWithPosition() {
        DateFormat format = DateFormat.getDateInstance(DateFormat.FULL);
        Date date = new Date();
        String dateStr = format.format(date);
        String prefix = "== START ==";
        String toParse = prefix + dateStr + "== END ==";
        ParsePosition position = new ParsePosition(prefix.length());
        Date d = format.parse(toParse, position);
        int index = position.getIndex();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DateTimeFormat dtf = new DateTimeFormat();
        dtf.trackFormatPosition();
        dtf.parseWithPosition();
    }
}
