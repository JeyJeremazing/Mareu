package com.example.mareu.service;

import com.example.mareu.model.Attendees;
import com.example.mareu.model.Meeting;
import com.example.mareu.model.Room;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class DummyMeetingGenerator {

    public static List<Meeting> DUMMY_ATTENDEES = Arrays.asList(
            new Meeting("Informatique",new Room("Yoda"),"jeremy@jeymail.fr"),
            new Meeting("Rénovation",new Room("Wookies"),"jeremy@jeymail.fr"),
            new Meeting("Chiffre d'affaire",new Room("Jedi"),"jeremy@jeymail.fr"),
            new Meeting("Conflits",new Room("Sith"),"jeremy@jeymail.fr"),
            new Meeting("RH",new Room("Rancor"),"jeremy@jeymail.fr"),
            new Meeting("Application Mareu",new Room("Grogu"),"jeremy@jeymail.fr"),
            new Meeting("Gestion des stocks",new Room("Mandalorian"),"jeremy@jeymail.fr"),
            new Meeting("Augmentation de capital",new Room("Darth Vader"),"jeremy@jeymail.fr"),
            new Meeting("Pertes",new Room("Darth Sidious"),"jerome@jeymail.fr"
                    + new Attendees("benoitdesauffret@gmail.fr") +new Attendees("christelle@gmail.fr")),
            new Meeting(" Syndicat",new Room("Yoda"),"jeremy@jeymail.fr")
    );

    static List<Meeting> generateMeetings() { return new ArrayList<>(DUMMY_ATTENDEES); }
}
