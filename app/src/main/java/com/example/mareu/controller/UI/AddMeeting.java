package com.example.mareu.controller.UI;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.example.mareu.DI.DI;
import com.example.mareu.R;
import com.example.mareu.service.MeetingApiService;

public class AddMeeting extends AppCompatActivity {
    
    MeetingApiService mApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_meeting);
        mApiService = DI.getMeetingApiService();
    }
}