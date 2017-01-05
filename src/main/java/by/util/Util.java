package by.util;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Util {

    public static Date getDateToString(String strDate) {

        DateFormat format = new SimpleDateFormat("MMM d,yyyy", Locale.ENGLISH);
        Date date = new Date();
        try {
            date = format.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println("Converter to Date fail");
        }
        return date;
    }
}

