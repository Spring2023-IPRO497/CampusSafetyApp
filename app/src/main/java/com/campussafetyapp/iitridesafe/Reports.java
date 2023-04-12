package com.campussafetyapp.iitridesafe;

public class Reports {

    String title;
    String info;
    String date;

    Reports(String t, String i, String d){
        title = t;
        info = i;
        date = d;
    }

    public String getTitle() {
        return title;
    }

    public String getInfo() {
        return info;
    }

    public String getDate() {
        return date;
    }
}
