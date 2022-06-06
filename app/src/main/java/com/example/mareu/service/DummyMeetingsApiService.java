package com.example.mareu.service;


import com.example.mareu.model.Meeting;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DummyMeetingsApiService implements MeetingApiService {

    private final List<Meeting> meetings= DummyMeetingGenerator.generateMeetings();
    private final List<String> roomsList = DummyMeetingGenerator.roomsList();

    @Override
    public List<String> getRoomsList() {
        return roomsList;
    }

    @Override
    public List<Meeting> getMeetings() { return meetings; }

    @Override
    public void deleteMeetings(Meeting meeting) { meetings.remove(meeting); }

    @Override
    public void createMeetings(Meeting meeting) { meetings.add(meeting); }

    @Override
    public List<Meeting> getMeetingsFilteredByDate(Date date) {

        ArrayList<Meeting> result = new ArrayList<>();

        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date);
        
        for (int i = 0; i < meetings.size(); i++) {
            Calendar cal2 = Calendar.getInstance();
            cal2.setTime(meetings.get(i).getDate());
            boolean sameDay = cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR) &&
                    cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR);
            if (sameDay) result.add(meetings.get(i));

        }
        return result;
    }

   @Override
    public List<String> getRoomsFiltered(String rooms) {
       ArrayList<Meeting> resultRooms = new ArrayList<>();

       return null;
    }
}
