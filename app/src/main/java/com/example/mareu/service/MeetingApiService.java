package com.example.mareu.service;

import com.example.mareu.model.Attendees;
import com.example.mareu.model.Meeting;

import java.util.List;

public interface MeetingApiService {

    List<Meeting> getMeetings();

    void deleteMeetings(Meeting meeting);

    void createMeetings(Meeting meeting);
}
