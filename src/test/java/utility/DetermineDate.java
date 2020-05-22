package utility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DetermineDate {

    private static int determineDate;

    public static String getDetermineDate(){
        return DetermineDate(determineDate);
    }

    public static void setDetermineDate(int day) {
        DetermineDate.determineDate = day;
    }

    private static String DetermineDate (int dataDay){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, dataDay);
        Date day = calendar.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(day);
    }

}
