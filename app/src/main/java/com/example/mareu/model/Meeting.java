package com.example.mareu.model;


import java.util.Date;

public class Meeting {

    private int meetingID;
    private String nameOfMeeting;
    private String room;
    private String attendeesMail;
    private Date date;

    public Meeting(int meetingID, String nameOfMeeting, String room, String attendeesMail) {
        this.meetingID = meetingID;
        this.nameOfMeeting = nameOfMeeting;
        this.attendeesMail = attendeesMail;
        this.room = room;
        this.date = new Date();
    }

    public Meeting(int meetingID, String nameOfMeeting, String room, String attendeesMail, Date date) {
        this.meetingID = meetingID;
        this.nameOfMeeting = nameOfMeeting;
        this.attendeesMail = attendeesMail;
        this.room = room;
        this.date = date;
    }

    public int getMeetingID() {
        return meetingID;
    }

    public String getNameOfMeeting() {
        return nameOfMeeting;
    }

    public void setNameOfMeeting(String nameOfMeeting) {
        this.nameOfMeeting = nameOfMeeting;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getAttendeesMail() {
        return attendeesMail;
    }

    public void setAttendeesMail(String attendeesMail) {
        this.attendeesMail = attendeesMail;
    }

    public Date getDate() {
        return date;
    }


}

