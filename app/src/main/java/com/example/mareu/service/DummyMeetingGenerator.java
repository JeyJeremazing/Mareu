package com.example.mareu.service;

import com.example.mareu.model.Attendees;
import com.example.mareu.model.Meeting;
import com.example.mareu.model.Room;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class DummyMeetingGenerator {

    public static List<Meeting> DUMMY_ATTENDEES = Arrays.asList(
            new Meeting("Réunion",new Room("Yoda"),"jeremy@jeymail.fr"),
            new Meeting("Réunion",new Room("Wookies"),"jeremy@jeymail.fr,clarissabella@hotmail.fr"),
            new Meeting("Réunion",new Room("Jedi"),"jeremy@jeymail.fr"),
            new Meeting("Réunion",new Room("Sith"),"jeremy@jeymail.fr"),
            new Meeting("Réunion",new Room("Rancor"),"jeremy@jeymail.fr"),
            new Meeting("Réunion ",new Room("Grogu"),"jeremy@jeymail.fr"),
            new Meeting("Réunion",new Room("Mandalorian"),"jeremy@jeymail.fr"),
            new Meeting("Réunion",new Room("Darth Vader"),"jeremy@jeymail.fr"),
            new Meeting("Réunion",new Room("Darth Sidious"),"jerome@jeymail.fr"),
            new Meeting("Réunion",new Room("Yoda"),"jeremy@jeymail.fr"),
            new Meeting("Réunion",new Room("Wookies"),"jeremy@jeymail.fr"),
            new Meeting("Réunion",new Room("Jedi"),"jeremy@jeymail.fr"),
            new Meeting("Réunion",new Room("Sith"),"jeremy@jeymail.fr"),
            new Meeting("Réunion",new Room("Rancor"),"jeremy@jeymail.fr"),
            new Meeting("Réunion",new Room("Grogu"),"jeremy@jeymail.fr"),
            new Meeting("Réunion",new Room("Mandalorian"),"jeremy@jeymail.fr"),
            new Meeting("Réunion",new Room("Darth Vader"),"jeremy@jeymail.fr"),
            new Meeting("Réunion",new Room("Darth Sidious"),"jerome@jeymail.fr")
    );

    static List<Meeting> generateMeetings() { return new ArrayList<>(DUMMY_ATTENDEES); }
}
