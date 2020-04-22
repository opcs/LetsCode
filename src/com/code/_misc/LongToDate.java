package com.code._misc;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class LongToDate {


    public static void main(String[] args) {
        long earliestDepartTime = 1474916400000L;
        long earliestDeliveryTime = 1475128800000L;
        long latestDepartTime = 1475042400000L;
        long latestDeliveryTime = 1478458800000L;

        Date pick1 = new Date(earliestDepartTime);
        System.out.println(pick1.toString());
        Date pick2 = new Date(latestDepartTime);

        Date drop1 = new Date(earliestDeliveryTime);
        Date drop2 = new Date(latestDeliveryTime);
        SimpleDateFormat shortsdf = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm a zzz");
        sdf.setTimeZone(TimeZone.getTimeZone("PST"));
        String pickup1 = sdf.format(pick1);
        String pickup2 = sdf.format(pick2);
        String dropoff1 = sdf.format(drop1);
        String dropoff2 = sdf.format(drop2);

        System.out.println("pick: " + pickup1 + "  " + pickup2);
        System.out.println("drop: " + dropoff1 + "  " + dropoff2);

    }

}

/*
 * "earliestDepartTime": 1474869600000,
 * "earliestDeliveryTime": 1475128800000,
 * "latestDepartTime": 1475042400000,
 * "latestDeliveryTime": 1478458800000
 */