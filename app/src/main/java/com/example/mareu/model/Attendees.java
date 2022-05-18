package com.example.mareu.model;


public class Attendees {

    //FIELDS

    private String attendeesMail;

    //CONSTRUCTOR
    public Attendees(String attendeesMail) {

        this.attendeesMail = attendeesMail;
    }

    //GETTERS & SETTERS

    public String getAttendeesMail() {
        return attendeesMail;
    }

    public void setAttendeesMail(String attendeesMail) {
        this.attendeesMail = attendeesMail;
    }
}
