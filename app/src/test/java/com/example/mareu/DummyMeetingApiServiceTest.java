package com.example.mareu;

import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
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
        assertTrue(numberMeetingsBefore > numberMeetingAfter);
    }

    @Test
    public void createMeeting() {
        Meeting meeting = new Meeting(50, "Cantine", "Sidious", "hardcoder@codeisgood.com", new Date());
        meetingsApiService.createMeetings(meeting);
        assertTrue(meetingsApiService.getMeetings().contains(meeting));
    }

    @Test
    public void getMeetingsFilteredByDate() {
        List<Meeting> meetingsDates = this.meetingsApiService.getMeetings();
        assertEquals(meetingsDates.size(), 7);
        Meeting date = meetingsDates.get(0);
        Meeting date2 = meetingsDates.get(1);
        meetingsDates = meetingsApiService.getMeetingsFilteredByDate(date.getDate());
        assertEquals(meetingsDates.size(), 2);
        assertThat(meetingsDates, containsInAnyOrder(date, date2));
    }

    @Test
    public void getMeetingFilteredByRoom() {
        //List
        List<Meeting> meetings = this.meetingsApiService.getMeetings();
        //Check there are seven items on the list
        assertEquals(meetings.size(), 7);
        //Create a meeting with a room
        Meeting meeting2 = new Meeting(50, "Cantine", "Jawas", "hardcoder@codeisgood.com", new Date());
        meetingsApiService.createMeetings(meeting2);
        Meeting meeting3 = new Meeting(51, "Cantine", "Jawas", "hardcoder@codeisgood.com", new Date());
        meetingsApiService.createMeetings(meeting3);
        //Check that the meeting is added
        assertTrue(meetingsApiService.getMeetings().contains(meeting2));
        //Check there are 8 items in the list
        assertEquals(meetings.size(), 9);
        //Put the getMeetingFilteredByRoom in meetingsRooms
        meetings = meetingsApiService.getMeetingFilteredByRoom("Jawas");
        //Now check that there are 2 items int the list
        assertEquals(meetings.size(), 2);
        // I check that they are in meetingsRooms.
        assertThat(meetings, containsInAnyOrder(meeting2, meeting3));
    }
}

