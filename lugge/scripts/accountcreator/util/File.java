package org.lugge.scripts.accountcreator.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class File {
    public static String LOG_PATH;
    public static String LOG_NAME;
    
    public static void writeLog(String message) {
        String MessageAndDate = Time.getCalender(Time.calender.DATE) + " - " + Time.getCalender(Time.calender.TIME) + "   " + message;
        System.out.println(MessageAndDate);
        BufferedWriter out;
        if (LOG_PATH != null && LOG_NAME != null) {
            try {
                out = new BufferedWriter(new FileWriter(new java.io.File(LOG_PATH + java.io.File.separator + LOG_NAME), true));
                out.write(MessageAndDate);
                out.newLine();
                out.close();
            } catch (final IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void writeFile(String message, String fileName, boolean timeAndDate) {
        String messageAndDate;
        if(timeAndDate) {
            messageAndDate = Time.getCalender(Time.calender.DATE) + " - " + Time.getCalender(Time.calender.TIME) + "   " + message;
        }else{
            messageAndDate = message;
        }
       
        System.out.println(messageAndDate);
        BufferedWriter out;
        if (LOG_PATH != null && fileName != null) {
            try {
                out = new BufferedWriter(new FileWriter(new java.io.File(LOG_PATH + java.io.File.separator + fileName + ".txt"), true));
                out.write(messageAndDate);
                out.newLine();
                out.close();
            } catch (final IOException e) {
                e.printStackTrace();
            }
        }
    }
}
