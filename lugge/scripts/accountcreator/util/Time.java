package org.lugge.scripts.accountcreator.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Time {
    enum calender {
        TIME,
        DATE
    }

    public static String getCalender(calender calender) {
        switch (calender) {
            case TIME:
                return new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
            case DATE:
                return new SimpleDateFormat("yyyy.MM.dd").format(Calendar.getInstance().getTime());
        }
        return "Null";
    }

    public static String runtime(final long time) {
        final StringBuilder t = new StringBuilder();
        final long total_secs = time / 1000;
        final long total_mins = total_secs / 60;
        final long total_hrs = total_mins / 60;
        final long total_days = total_hrs / 24;
        final int secs = (int) total_secs % 60;
        final int mins = (int) total_mins % 60;
        final int hrs = (int) total_hrs % 24;
        final int days = (int) total_days;
        if (days > 0) {
            if (days < 10) {
                t.append("0");
            }
            t.append(days);
            t.append(":");
        }
        if (hrs < 10) {
            t.append("0");
        }
        t.append(hrs);
        t.append(":");
        if (mins < 10) {
            t.append("0");
        }
        t.append(mins);
        t.append(":");
        if (secs < 10) {
            t.append("0");
        }
        t.append(secs);
        return t.toString();
    }
}
