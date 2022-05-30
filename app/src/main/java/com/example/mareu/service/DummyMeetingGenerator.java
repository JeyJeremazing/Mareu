package com.example.mareu.service;

import com.example.mareu.model.Meeting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public abstract class DummyMeetingGenerator {

    public static List<Meeting> DUMMY_ATTENDEES = Arrays.asList(
            new Meeting(001, "OBJECTIFS", "Yoda", "mandalourien@jeymail.fr", new Date(1626470805000L)),
            new Meeting(002, "TOILETTES", "Wookies", "georges_lucas@skywalker_ranch.fr", new Date()),
            new Meeting(003, "CANTINE", "Jedi", "jeremy@jeymail.fr;clarissa@glove.fr",new Date()),
            new Meeting(004, "APPLICATION", "Sith", "darkangel64@poulpy.fr,benoit92@salut.fr", new Date()),
            new Meeting(005, "INVENTAIRE", "Rancor", "jeremy@jeymail.fr", new Date()),
            new Meeting(006, "RH ", "Grogu", "jeremy@jeymail.fr", new Date()),
            new Meeting(007, "SERVICE", "Ewoks", "jamesbond@mi6.fr", new Date())

    );

    public static List<String> ROOMS = Arrays.asList("Yoda","Wookies");

    static List<Meeting> generateMeetings() {
        return new ArrayList<>(DUMMY_ATTENDEES);
    }
}
