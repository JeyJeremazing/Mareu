package com.example.mareu.service;

import com.example.mareu.model.Meeting;

import java.util.Date;
import java.util.List;

public interface MeetingApiService {

    List<String> getRoomsList();

    List<Meeting> getMeetings();

    void deleteMeetings(Meeting meeting);

    void createMeetings(Meeting meeting);

    List<Meeting> getMeetingsFilteredByDate(Date date);

    List<Meeting> getMeetingFilteredByRoom(String room);

}
