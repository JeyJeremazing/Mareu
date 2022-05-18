package com.example.mareu.model;


public class Meeting {
    //FIELDS
    private String nameOfMeeting;
    private Room room;
    private String attendeesMail;

    //CONSTRUCTOR
    public Meeting(String nameOfMeeting, Room room, String attendeesMail) {
        this.nameOfMeeting = nameOfMeeting;
        this.attendeesMail = attendeesMail;
        this.room = room;
    }

    //GETTERS & SETTERS
    public String getNameOfMeeting() { return nameOfMeeting; }

    public void setNameOfMeeting(String nameOfMeeting) { this.nameOfMeeting = nameOfMeeting; }

    public Room getRoom() { return room; }

    public void setRoom(Room room) { this.room = room; }

    public String getAttendeesMail() { return attendeesMail; }

    public void setAttendeesMail(String attendeesMail) { this.attendeesMail = attendeesMail; }
}

