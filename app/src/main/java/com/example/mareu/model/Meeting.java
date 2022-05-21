package com.example.mareu.model;


public class Meeting {

    private String nameOfMeeting;
    private String room;
    private String attendeesMail;
    private String date;

    public Meeting(String nameOfMeeting, String room, String attendeesMail,String date) {
        this.nameOfMeeting = nameOfMeeting;
        this.attendeesMail = attendeesMail;
        this.room = room;
        this.date = date;
    }

    public String getNameOfMeeting() { return nameOfMeeting; }

    public void setNameOfMeeting(String nameOfMeeting) { this.nameOfMeeting = nameOfMeeting; }

    public String getRoom() { return room; }

    public void setRoom(String room) { this.room = room; }

    public String getAttendeesMail() { return attendeesMail; }

    public void setAttendeesMail(String attendeesMail) { this.attendeesMail = attendeesMail; }

    public String getDate() { return date; }

    public void setDate(String date) { this.date = date; }
}

