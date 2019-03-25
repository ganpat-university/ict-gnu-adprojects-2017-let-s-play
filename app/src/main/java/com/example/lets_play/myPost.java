package com.example.lets_play;

public class myPost {
    private String place;
    private String title;
    private String time;
    private String date;

    public myPost(){

    }

    public myPost(String place, String title, String time, String date) {
        this.place = place;
        this.title = title;
        this.time = time;
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}
