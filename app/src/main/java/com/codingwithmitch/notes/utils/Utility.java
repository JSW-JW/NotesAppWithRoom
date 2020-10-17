package com.codingwithmitch.notes.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utility {

    public static String getCurrentTimestamp(){  // static method for using the method without instantiating the object
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy"); // lower case 'y' for api 23 and below

        String currentDate = dateFormat.format(new Date());
        return currentDate;
    }

    public static String getMonthFromNumber(String monthNumber){
        String monthString = "";
        switch (monthNumber) {
            case "01":
                monthString = "Jan";
                break;
            case "02":
                monthString = "Feb";
                break;
            case "03":
                monthString = "March";
                break;
            case "04":
                monthString = "April";
                break;
            case "05":
                monthString = "May";
                break;
            case "06":
                monthString = "June";
                break;
            case "07":
                monthString = "July";
                break;
            case "08":
                monthString = "Aug";
                break;
            case "09":
                monthString = "Sep";
                break;
            case "10":
                monthString = "Oct";
                break;
            case "11":
                monthString = "Nov";
                break;
            case "12":
                monthString = "Dec";
                break;
            default:
                monthString = "Error";
        }
        return monthString;
    }
}
