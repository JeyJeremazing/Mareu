package com.example.mareu.service;

import com.example.mareu.model.Meeting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class DummyMeetingGenerator {

    public static List<Meeting> DUMMY_ATTENDEES = Arrays.asList(
            new Meeting(001, "OBJECTIFS", "Yoda", "jeremy@jeymail.fr", ""),
            new Meeting(002, "TOILETTES", "Wookies", "jeremy@jeymail.fr", ""),
            new Meeting(003, "CANTINE", "Jedi", "jeremy@jeymail.fr", ""),
            new Meeting(004, "APPLICATION", "Sith", "jeremy@jeymail.fr", ""),
            new Meeting(005, "INVENTAIRE", "Rancor", "jeremy@jeymail.fr", ""),
            new Meeting(006, "RH ", "Grogu", "jeremy@jeymail.fr", ""),
            new Meeting(007, "SERVICESECRETS", "Mandalorian", "jamesbond@mi6.fr", "")

    );

    static List<Meeting> generateMeetings() {
        return new ArrayList<>(DUMMY_ATTENDEES);
    }
}
