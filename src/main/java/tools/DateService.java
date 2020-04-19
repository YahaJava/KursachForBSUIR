package tools;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateService {
    public long getIntDate(String stringDate) {
        Date date;
        DateFormat formatter = new SimpleDateFormat("dd.MM.yy HH:mm");
        try {
            date = formatter.parse(stringDate);
            return date.getTime();

        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }
    }


    public long getCurrentDate() {
        Date date = new Date();
        return date.getTime();
    }
}
