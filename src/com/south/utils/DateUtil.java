package com.south.utils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public static final String yyyyMMdd="yyyy-MM-dd";

    // string -> date
    public static Date parseToDate(String s, String style) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();	
        simpleDateFormat.applyPattern(style); // 将给定的模式字符串应用于此日期格式

        Date date = null;
        if(s==null||s.length()<8)						
            return null;								
        try {
            date = simpleDateFormat.parse(s);			
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    // date -> string
    public static String parseToString(Date date, String style) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();		
        simpleDateFormat.applyPattern(style);

        String str = null;
        if(date==null)									
            return null;								
        str=simpleDateFormat.format(date);				
        return str;
    }
}