package com.code._misc;
/*import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.joda.time.DateTime;
import org.joda.time.DateTimeUtils;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class TestOperatingHours {
    public static void main (String[] args){
        
        TestOperatingHours testOH = new TestOperatingHours();
        
        testOH.testOHTime();
        
    }
    
    
    public void testOHTime (){
        String locationTimeZoneStr = "America/Los_Angeles";
        
        //"America/Los_Angeles"
        //"Asia/Calcutta"
        
        //    create location operating data for a week
        HashMap<Integer, OperatingHours> weeklyOH = new HashMap<Integer, OperatingHours>();
        
        weeklyOH.put ( 1, new OperatingHours(1, "04:00", "10:00" ));
        weeklyOH.put ( 2, new OperatingHours(2, "04:00", "10:00" ));
        weeklyOH.put ( 3, new OperatingHours(3, "04:00", "10:00" ));
        weeklyOH.put ( 4, new OperatingHours(4, "04:00", "10:00" ));
        weeklyOH.put ( 5, new OperatingHours(5, "04:00", "10:00" ));
        weeklyOH.put ( 6, new OperatingHours(6, "15:00", "23:00" ));
        weeklyOH.put ( 7, new OperatingHours(7, "15:00", "23:00" ));


        HashMap <Integer, OperatingHours> lconvertedTOUTC = convertOHFromLocationTzToUTCTz(locationTimeZoneStr,weeklyOH);
        
        // loop through the converted UTC OH
        
        Iterator uEntries = lconvertedTOUTC.entrySet().iterator();
        while (uEntries.hasNext()) {
            Map.Entry uEntry = (Map.Entry) uEntries.next();
            Integer ukey = (Integer)uEntry.getKey();
            OperatingHours uvalue = (OperatingHours) uEntry.getValue();
            
            System.out.println("UTC Key = " + ukey + ", Value = " + uvalue.getDayOfWeek() + " "+ uvalue.getStartTime() + " "+uvalue.getEndTime());
        }
        
        return;
    }
    
    // converts location specific operating hours to UTC hours
    public HashMap <Integer, OperatingHours> convertOHFromLocationTzToUTCTz (String locationTimeZoneStr, HashMap <Integer, OperatingHours> weeklyOH) {
    
        int i = 1;
        
        String splitStart = "00:01";
        String splitEnd   = "23:59";
        
        //create an empty UTCWeeklyOH
        HashMap<Integer, OperatingHours> weeklyUTCOH = new HashMap<Integer, OperatingHours>();

        //getCurrent Date
        DateTime currentDateTime = new DateTime();
        
        //move the currentDateTime to the begining of the week
        DateTime weekStartDate = new DateTime(currentDateTime.minusDays(currentDateTime.getDayOfWeek()-1));
        
        System.out.println("Current DateTime "+ currentDateTime.toString());
        System.out.println("Current Week Start Date "+ weekStartDate.toDate());
        
        DateTimeZone tz = DateTimeZone.forID("UTC");
        
        DateTimeZone.setDefault(tz);
        
        //build a time zone based on Location time zone
        DateTimeZone locationTimeZone = DateTimeZone.forID(locationTimeZoneStr);
        
        //getCurrentUTCDate
        DateTime utcDate = new DateTime(weekStartDate.toDateTime(DateTimeZone.UTC));

        int utcDayOfWeek = utcDate.getDayOfWeek();
        
        System.out.println("UTC Date : " + utcDate+ ", Day of Week "+utcDayOfWeek);        
        
        Iterator<Entry<Integer, OperatingHours>> entries = weeklyOH.entrySet().iterator();
        while (entries.hasNext()) {
            Entry<Integer, OperatingHours> entry =  entries.next();
            OperatingHours value = (OperatingHours) entry.getValue();
           
            String lStartTime = value.getStartTime();
            String lEndTime   = value.getEndTime();
            int lDayOfWeek    = value.getDayOfWeek();
            
            int cDayOfWeek = lDayOfWeek;

            String[] startHourMin = lStartTime.split(":");
            
            int lStartTimeHours = Integer.parseInt(startHourMin[0]);
            int lStartTimeMinutes = Integer.parseInt(startHourMin[1]);
            System.out.println( "start hours "+ lStartTimeHours+ ", mins "+ lStartTimeMinutes);
            
            String[] endHourMin = lEndTime.split(":");
            
            int lEndTimeHours = Integer.parseInt(endHourMin[0]);
            int lEndTimeMinutes = Integer.parseInt(endHourMin[1]);
            
            System.out.println( "end hours "+ lEndTimeHours + ", mins "+ lEndTimeMinutes);

            //loop through the currentDate to find the matching day of Week
            if (lDayOfWeek == 0) {
                cDayOfWeek = 7;
            }
                                  
            //convert location start and end time to UTC
            DateTime lStartDateTime = new DateTime (weekStartDate.getYear(), weekStartDate.getMonthOfYear(), weekStartDate.getDayOfMonth() + cDayOfWeek -1,lStartTimeHours,lStartTimeMinutes,0, locationTimeZone);
            DateTime lEndDateTime = new DateTime (weekStartDate.getYear(), weekStartDate.getMonthOfYear(), weekStartDate.getDayOfMonth() + cDayOfWeek -1,lEndTimeHours,lEndTimeMinutes,0, locationTimeZone);
            
            System.out.println("Location Start Date : " + lStartDateTime + ", End Date :"+ lEndDateTime );
            
            //convert both the start and end location hours into UTC           
            DateTime lUTCStartDateTime = new DateTime(lStartDateTime.toDateTime(DateTimeZone.UTC));
            DateTime lUTCEndDateTime   = new DateTime(lEndDateTime.toDateTime(DateTimeZone.UTC));
            
            System.out.println("Location UTC Start Date : " + lUTCStartDateTime + ", End Date :"+ lUTCEndDateTime );
            
            // build the Location Start/End in UTC HashMap
            
            // adjust and split the dayOfWeek if the time has shifted back or forward
            
            int lStartDayOfWeekShift  = lStartDateTime.getDayOfWeek() - lUTCStartDateTime.getDayOfWeek();
            int lEndDayOfWeekShift    = lEndDateTime.getDayOfWeek() - lUTCEndDateTime.getDayOfWeek();
                      
            //start time in UTC
            String startUTCTimeInHoursMin = String.valueOf(lUTCStartDateTime.getHourOfDay())+":" + String.valueOf(lUTCStartDateTime.getMinuteOfHour());
            
            //end time in UTC
            String endUTCTimeInHoursMin = String.valueOf(lUTCEndDateTime.getHourOfDay())+":" + String.valueOf(lUTCEndDateTime.getMinuteOfHour());
            
            System.out.println("Location UTC Start Time "+ startUTCTimeInHoursMin + ",End Time" + endUTCTimeInHoursMin);
            
            int startDayOfWeek = lUTCStartDateTime.getDayOfWeek();
            
            // check if day if week has shifted based on the conversion
            if ((lStartDayOfWeekShift < 0) || (lEndDayOfWeekShift > 0) ) {
                OperatingHours ohUTC = new OperatingHours(startDayOfWeek, startUTCTimeInHoursMin, splitEnd);
                
                weeklyUTCOH.put(i,ohUTC);
                startDayOfWeek = lUTCEndDateTime.getDayOfWeek();
                startUTCTimeInHoursMin = splitStart;               
                i++;
                
            } else if (lStartDayOfWeekShift > 0 || lEndDayOfWeekShift < 0) {
                
                OperatingHours ohUTC = new OperatingHours(lUTCStartDateTime.getDayOfWeek(), startUTCTimeInHoursMin, splitEnd);
                
                weeklyUTCOH.put(i,ohUTC);
                startDayOfWeek = lUTCEndDateTime.getDayOfWeek();                
                startUTCTimeInHoursMin = splitStart;
                i++;
            }
            
            // same day time slot or left over time slot
            OperatingHours ohUTC = new OperatingHours(startDayOfWeek, startUTCTimeInHoursMin, endUTCTimeInHoursMin);
            
            weeklyUTCOH.put(i,ohUTC);
            i++;    
        }
        return weeklyUTCOH;
    }
    
    public void printZodaTimeZoneNames(){
        Set<String> zoneIds = DateTimeZone.getAvailableIDs();
        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("ZZ");
        
        for (String zoneId : zoneIds) {
            String offset = dateTimeFormatter.withZone(DateTimeZone.forID(zoneId)).print(0);
            String longName = DateTimeZone.forID(zoneId).getName(DateTimeUtils.currentTimeMillis());
            
            System.out.println("(" + offset + ") " + zoneId + ", " + longName);
        }
    }
}


class OperatingHours {
    
    private int dayOfWeek;
    private String startTime;
    private String endTime;
    
    public OperatingHours(int vdayOfWeek, String vstartTime, String vendTime) {
        this.dayOfWeek= vdayOfWeek;
        this.startTime= vstartTime;
        this.endTime= vendTime;
    }
    
    public int getDayOfWeek(){
        return dayOfWeek;
    }
    
    public String getStartTime(){
        return startTime;
    }
    
    public String getEndTime(){
        return endTime;
    }
    
}

*/