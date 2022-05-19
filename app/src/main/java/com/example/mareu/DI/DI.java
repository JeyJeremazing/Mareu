package com.example.mareu.DI;

import com.example.mareu.service.DummyMeetingsApiService;
import com.example.mareu.service.MeetingApiService;

public class DI {

    private static MeetingApiService service = new DummyMeetingsApiService();

    public static MeetingApiService getMeetingApiService(){return service; }

    public static MeetingApiService getNewInstanceApiService(){
        return new DummyMeetingsApiService();
    }
}
