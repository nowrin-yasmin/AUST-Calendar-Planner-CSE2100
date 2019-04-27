package com.example.nowrin.austcalendarplanner;

import android.util.EventLog;

/**
 * Created by Nowrin on 2/13/2018.
 */

public class Events {
    int id;
    String EventName;
    String EventDate;
    String EventTime;
    String EventNote;

    public Events(String EventName, String EventDate, String EventTime, String EventNote){
        this.EventName = EventName;
        this.EventDate = EventDate;
        this.EventTime = EventTime;
        this.EventNote = EventNote;

    }

    public Events(int id, String EventName, String EventDate, String EventTime, String EventNote){
        this.id = id;
        this.EventName = EventName;
        this.EventDate = EventDate;
        this.EventTime = EventTime;
        this.EventNote = EventNote;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEventName() {
        return EventName;
    }

    public void setEventName(String eventName) {
        EventName = eventName;
    }

    public String getEventDate() {
        return EventDate;
    }

    public void setEventDate(String eventDate) {
        EventDate = eventDate;
    }

    public String getEventTime() {
        return EventTime;
    }

    public void setEventTime(String eventTime) {
        EventTime = eventTime;
    }

    public String getEventNote() {
        return EventNote;
    }

    public void setEventNote(String eventNote) {
        EventNote = eventNote;
    }
}
