package com.example.mareu.controller;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.example.mareu.DI.DI;
import com.example.mareu.controller.UI.AddMeeting;
import com.example.mareu.controller.UI.MeetingAdapter;
import com.example.mareu.databinding.ActivityMeetingDetailsBinding;
import com.example.mareu.model.Meeting;
import com.example.mareu.service.MeetingApiService;


import java.util.ArrayList;


public class MeetingsListActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityMeetingDetailsBinding binding;
    private MeetingApiService mMeetingApiService = DI.getMeetingApiService();
    private MeetingAdapter mAdapter;


    private void initUI() {
        binding = ActivityMeetingDetailsBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        setButton();
        initRecyclerView();
    }

    private void initRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.recyclerView.setLayoutManager(layoutManager);
        mAdapter = new MeetingAdapter(new ArrayList<>(mMeetingApiService.getMeetings()));
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(binding.recyclerView.getContext(),
                layoutManager.getOrientation());
        binding.recyclerView.addItemDecoration(dividerItemDecoration);
        binding.recyclerView.setAdapter(mAdapter);
    }

    private void setButton() {
        binding.floatingActionButton.setOnClickListener(this);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initUI();
    }
    @Override
    protected void onResume() {
        super.onResume();
        mAdapter.updateList(mMeetingApiService.getMeetings());
    }

    @Override
    public void onClick(View view) {
        if (view == binding.floatingActionButton) {
            startActivity(new Intent(this, AddMeeting.class));


        }
    }
}

