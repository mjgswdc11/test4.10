package sample.util;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class StringUtil {
    public static boolean isEmpty(String text){
        return text ==null||text.trim().equals("");
    }
    public static String localdateToString(LocalDate date){

        if(date==null)return null;
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String localDateStr = date.format(fmt);
        return localDateStr;
    }
    public static String dateToString(Date date){

        if(date==null)return null;
        return new SimpleDateFormat("yyyy-MM-dd").format(date);

    }
}
