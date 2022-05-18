package com.example.mareu.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.mareu.R;
import com.example.mareu.controller.UI.MeetingAdapter;
import com.example.mareu.model.Attendees;
import com.example.mareu.model.Meeting;
import com.example.mareu.model.Rooms;

import java.util.ArrayList;

public class MeetingDetail extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meeting_details);

        ArrayList<Meeting>meetingList = new ArrayList<>();
        meetingList.add(new Meeting("Problème","Peach","clarissa@jeymail.fr"));


       mRecyclerView = findViewById(R.id.recyclerView);
       mRecyclerView.setHasFixedSize(true);
       mLayoutManager = new LinearLayoutManager(this);
       mAdapter = new MeetingAdapter(meetingList);

       mRecyclerView.setLayoutManager(mLayoutManager);
       mRecyclerView.setAdapter(mAdapter);
    }
}