package com.example.mareu.model;


public class Meeting {

    //FIELDS
    private String nameOFMeeting;
    private int durationOfMeeting;
    private int numberAttendees;
    private String meetingsTheme;
    private String meetingsReport;
    private String meetingsDate;

    //CONSTRUCTOR
    public Meeting(int durationOfMeeting, int numberAttendees, String meetingsTheme) {
        this.durationOfMeeting = durationOfMeeting;
        this.numberAttendees = numberAttendees;
        this.meetingsTheme = meetingsTheme;
    }

    //GETTERS & SETTERS


    public String getNameOFMeeting() {
        return nameOFMeeting;
    }

    public void setNameOFMeeting(String nameOFMeeting) {
        this.nameOFMeeting = nameOFMeeting;
    }

    public int getDurationOfMeeting() {
        return durationOfMeeting;
    }

    public void setDurationOfMeeting(int durationOfMeeting) {
        this.durationOfMeeting = durationOfMeeting;
    }

    public int getNumberAttendees() {
        return numberAttendees;
    }

    public void setNumberAttendees(int numberAttendees) {
        this.numberAttendees = numberAttendees;
    }

    public String getMeetingsTheme() {
        return meetingsTheme;
    }

    public void setMeetingsTheme(String meetingsTheme) {
        this.meetingsTheme = meetingsTheme;
    }

    public String getMeetingsReport() {
        return meetingsReport;
    }

    public void setMeetingsReport(String meetingsReport) {
        this.meetingsReport = meetingsReport;
    }

    public String getMeetingsDate() {
        return meetingsDate;
    }

    public void setMeetingsDate(String meetingsDate) {
        this.meetingsDate = meetingsDate;
    }
}
