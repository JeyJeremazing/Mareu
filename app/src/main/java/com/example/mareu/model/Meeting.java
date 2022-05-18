package com.example.mareu.model;


public class Meeting {
    //FIELDS
    private String nameOfMeeting;
    private String rooms;
    private String attendeesMail;

    //CONSTRUCTOR
    public Meeting(String nameOfMeeting,String rooms, String attendeesMail) {
        this.nameOfMeeting = nameOfMeeting;
        this.attendeesMail = attendeesMail;
        this.rooms = rooms;
    }

    //GETTERS & SETTERS
    public String getNameOfMeeting() { return nameOfMeeting; }

    public void setNameOfMeeting(String nameOfMeeting) { this.nameOfMeeting = nameOfMeeting; }

    public String getRooms() { return rooms; }

    public void setRooms(String rooms) { this.rooms = rooms; }

    public String getAttendeesMail() { return attendeesMail; }

    public void setAttendeesMail(String attendeesMail) { this.attendeesMail = attendeesMail; }
}

