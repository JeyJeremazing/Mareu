package com.example.mareu.service;

import com.example.mareu.model.Meeting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class DummyMeetingGenerator {

    public static List<Meeting> DUMMY_ATTENDEES = Arrays.asList(
            new Meeting("Réunion","Yoda","jeremy@jeymail.fr",""),
            new Meeting("Réunion","Wookies","jeremy@jeymail.fr",""),
            new Meeting("Réunion","Jedi","jeremy@jeymail.fr",""),
            new Meeting("Réunion","Sith","jeremy@jeymail.fr",""),
            new Meeting("Réunion","Rancor","jeremy@jeymail.fr",""),
            new Meeting("Réunion ","Grogu","jeremy@jeymail.fr",""),
            new Meeting("Réunion","Mandalorian","jeremy@jeymail.fr",""),
            new Meeting("Réunion","Darth Vader","jeremy@jeymail.fr",""),
            new Meeting("Réunion","Darth Sidious","jerome@jeymail.fr",""),
            new Meeting("Réunion","Yoda","jeremy@jeymail.fr",""),
            new Meeting("Réunion","Wookies","jeremy@jeymail.fr",""),
            new Meeting("Réunion","Jedi","jeremy@jeymail.fr",""),
            new Meeting("Réunion","Sith","jeremy@jeymail.fr",""),
            new Meeting("Réunion","Rancor","jeremy@jeymail.fr",""),
            new Meeting("Réunion","Grogu","jeremy@jeymail.fr",""),
            new Meeting("Réunion","Mandalorian","jeremy@jeymail.fr",""),
            new Meeting("Réunion","Darth Vader","jeremy@jeymail.fr",""),
            new Meeting("Réunion","Darth Sidious","jerome@jeymail.fr","")
    );

    static List<Meeting> generateMeetings() { return new ArrayList<>(DUMMY_ATTENDEES); }
}
