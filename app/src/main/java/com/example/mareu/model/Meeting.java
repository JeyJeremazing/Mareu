package com.example.mareu.model;


public class Meeting {

    private String nameOfMeeting;
    private String room;
    private String attendeesMail;

    public Meeting(String nameOfMeeting, String room, String attendeesMail) {
        this.nameOfMeeting = nameOfMeeting;
        this.attendeesMail = attendeesMail;
        this.room = room;
    }

    public String getNameOfMeeting() { return nameOfMeeting; }

    public void setNameOfMeeting(String nameOfMeeting) { this.nameOfMeeting = nameOfMeeting; }

    public String getRoom() { return room; }

    public void setRoom(String room) { this.room = room; }

    public String getAttendeesMail() { return attendeesMail; }

    public void setAttendeesMail(String attendeesMail) { this.attendeesMail = attendeesMail; }
}

