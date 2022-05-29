package com.example.mareu.service;

import com.example.mareu.model.Meeting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public abstract class DummyMeetingGenerator {

    public static List<Meeting> DUMMY_ATTENDEES = Arrays.asList(
            new Meeting(001, "OBJECTIFS", "Yoda", "jeremy@jeymail.fr", new Date(1626470805000L)),
            new Meeting(002, "TOILETTES", "Wookies", "jeremy@jeymail.fr", new Date()),
            new Meeting(003, "CANTINE", "Jedi", "jeremy@jeymail.fr",new Date()),
            new Meeting(004, "APPLICATION", "Sith", "jeremy@jeymail.fr", new Date()),
            new Meeting(005, "INVENTAIRE", "Rancor", "jeremy@jeymail.fr", new Date()),
            new Meeting(006, "RH ", "Grogu", "jeremy@jeymail.fr", new Date()),
            new Meeting(007, "SERVICE", "Ewoks", "jamesbond@mi6.fr", new Date())

    );

    static List<Meeting> generateMeetings() {
        return new ArrayList<>(DUMMY_ATTENDEES);
    }
}
