package com.op._misc;
/*import java.util.TimeZone;
import org.joda.time.DateTime;
import com.tradecard.framework.primitive.DateStamp;
import com.tradecard.framework.primitive.TimeOfDayStamp;
import com.tradecard.framework.primitive.Timestamp;

public class DateTimeTimeStamp {

    public static void main(String[] args) {

    }

    public static Timestamp getTimestampInUTC(final DateStamp date, final TimeOfDayStamp time) {
        return Timestamp.valueOf(date, time, TimeZone.getTimeZone("UTC"));
    }

    private static int getWeekday(final Timestamp datetime) {
        if (datetime != null) {
            DateTime dateTime = new DateTime(datetime.toMilliseconds());
            return (dateTime.getDayOfWeek());
        }
        return 0;
    }

    private static int getWeekOfYear(final Timestamp datetime) {
        if (datetime != null) {
            DateTime dateTime = new DateTime(datetime.toMilliseconds());
            return (dateTime.getWeekOfWeekyear());
        }
        return 0;
    }

    private static int getYear(final Timestamp datetime) {
        if (datetime != null) {
            DateTime dateTime = new DateTime(datetime.toMilliseconds());
            return dateTime.getWeekyear();
        }
        return 0;
    }
}
*/