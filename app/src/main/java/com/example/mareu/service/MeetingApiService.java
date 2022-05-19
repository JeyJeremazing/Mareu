package com.example.mareu.service;

import com.example.mareu.model.Meeting;

public interface MeetingApiService {

    Meeting getMeetings();

    void deleteMeetings(Meeting meeting);

    void createMeetings(Meeting meeting);
}
