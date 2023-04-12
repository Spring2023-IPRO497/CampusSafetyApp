package com.campussafetyapp.iitridesafe;

public class Reports {

    String title;
    String info;

    Reports(String t, String i){
        title = t;
        info = i;
    }

    public String getTitle() {
        return title;
    }

    public String getInfo() {
        return info;
    }
}
