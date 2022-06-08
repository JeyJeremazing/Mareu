package com.example.mareu;

import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

import com.example.mareu.model.Meeting;
import com.example.mareu.service.DummyMeetingGenerator;
import com.example.mareu.service.DummyMeetingsApiService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Date;
import java.util.List;

@RunWith(JUnit4.class)

public class DummyMeetingApiServiceTest {

    DummyMeetingsApiService meetingsApiService = new DummyMeetingsApiService();

    @Test
    public void getRoomsList() {
        List<String> rooms = this.meetingsApiService.getRoomsList();
        List<String> dummyRoom = DummyMeetingGenerator.ROOMS;
        assertThat(rooms, containsInAnyOrder(dummyRoom.toArray()));
    }

    @Test

    public void getMeetings() {
        List<Meeting> meetings = this.meetingsApiService.getMeetings();
        List<Meeting> dummyMeeting = DummyMeetingGenerator.DUMMY_ATTENDEES;
        assertThat(meetings, containsInAnyOrder(dummyMeeting.toArray()));
    }

    @Test

    public void deleteMeetings() {
        List<Meeting> meetings = this.meetingsApiService.getMeetings();
        Meeting meeting = meetings.get(0);
        int numberMeetingsBefore = meetings.size();
        meetingsApiService.deleteMeetings(meeting);
        int numberMeetingAfter = meetings.size();
        assertTrue(numberMeetingsBefore>numberMeetingAfter);
    }

    @Test
    public void createMeeting(){
        Meeting meeting = new Meeting(50,"Cantine","Sidious","hardcoder@codeisgood.com",new Date());
        meetingsApiService.createMeetings(meeting);
        assertTrue(meetingsApiService.getMeetings().contains(meeting));
    }

}

