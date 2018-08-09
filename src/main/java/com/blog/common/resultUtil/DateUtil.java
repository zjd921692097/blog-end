package com.blog.common.resultUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    public static Date afterDays(int n){
        Calendar calendar=Calendar.getInstance();
        calendar.set(Calendar.DATE,calendar.get(Calendar.DATE)-n);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String s = sdf.format(calendar.getTime());
        Date date=new Date();
        try {
            date =  sdf.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

}
