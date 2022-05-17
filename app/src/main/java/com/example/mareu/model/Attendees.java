package com.example.mareu.model;


public class Attendees {

    //FIELDS
    private String attendeesName;
    private String attendeesMail;

    //CONSTRUCTOR
    public Attendees(String attendeesName, String attendeesMail) {
        this.attendeesName = attendeesName;
        this.attendeesMail = attendeesMail;
    }

    //GETTERS & SETTERS
    public String getAttendeesName() {
        return attendeesName;
    }

    public void setAttendeesName(String attendeesName) {
        this.attendeesName = attendeesName;
    }

    public String getAttendeesMail() {
        return attendeesMail;
    }

    public void setAttendeesMail(String attendeesMail) {
        this.attendeesMail = attendeesMail;
    }
}
