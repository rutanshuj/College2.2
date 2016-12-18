package com.example.admin.college20;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.widget.ImageView;

/**
 * Created by Rutanshu Jhaveri on 10/10/2016.
 */
public class Events_list {
    private String title, cat_label, time_and_date;
    private int event_Img;

    public Events_list(String title, String cat_label, String time_and_date, int event_Img) {
        this.title = title;
        this.cat_label = cat_label;
        this.time_and_date = time_and_date;
        this.event_Img = event_Img;
    }




    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public String getTime_and_date() {
        return time_and_date;
    }

    public void setTime_and_date(String time_and_date) {
        this.time_and_date = time_and_date;
    }

    public String getCat_label() {
        return cat_label;
    }

    public void setCat_label(String cat_label) {
        this.cat_label = cat_label;
    }

    public int getImage(){return event_Img;}

    public void setEvent_Img(int event_Img){this.event_Img = event_Img;}

}
