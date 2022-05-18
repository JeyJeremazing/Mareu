package com.example.mareu.service;


import com.example.mareu.model.Attendees;
import com.example.mareu.model.Meeting;

import java.util.List;

public class DummyMeetingsApiService implements MeetingApiService {

    private List<Meeting> meetings= DummyMeetingGenerator.generateMeetings();

    @Override
    public List<Meeting> getMeetings() { return meetings; }

    @Override
    public void deleteMeetings(Meeting meeting) { meetings.remove(meeting); }

    @Override
    public void createMeetings(Meeting meeting) { meetings.add(meeting); }
}
