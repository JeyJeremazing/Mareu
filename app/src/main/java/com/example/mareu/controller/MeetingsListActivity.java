package com.example.mareu.controller;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mareu.DI.DI;
import com.example.mareu.R;
import com.example.mareu.controller.UI.AddMeeting;
import com.example.mareu.controller.UI.MeetingAdapter;
import com.example.mareu.databinding.ActivityMeetingListBinding;
import com.example.mareu.model.Meeting;
import com.example.mareu.service.ItemClickSupport;
import com.example.mareu.service.MeetingApiService;


public class MeetingsListActivity extends AppCompatActivity implements MeetingAdapter.Listener {

    ActivityMeetingListBinding binding;
    private MeetingApiService mMeetingApiService = DI.getMeetingApiService();
    private MeetingAdapter mAdapter;
    private Meeting meeting;


    private void initUI() {
        binding = ActivityMeetingListBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        setButton();
        initRecyclerView();
    }

    private void initRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.recyclerView.setLayoutManager(layoutManager);
        mAdapter = new MeetingAdapter(this.mMeetingApiService.getMeetings(), this);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(binding.recyclerView.getContext(),
                layoutManager.getOrientation());
        binding.recyclerView.addItemDecoration(dividerItemDecoration);
        binding.recyclerView.setAdapter(mAdapter);
    }

    private void setButton() {
        binding.floatingActionButton.setOnClickListener(v -> {
            if (v == binding.floatingActionButton) {
                startActivity(new Intent(getApplicationContext(), AddMeeting.class));
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initUI();
        configureOnClickRecyclerView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mAdapter.updateList(mMeetingApiService.getMeetings());
    }

    private void configureOnClickRecyclerView() {
        ItemClickSupport.addTo(binding.recyclerView, R.layout.item_meeting)
                .setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
                    @Override
                    public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                        meeting = mAdapter.getOneMeeting(position);
                        Toast.makeText(getApplicationContext(), "Réunion : " + meeting.getNameOfMeeting(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    @Override
    public void onClickDeleteButton(int position) {
        meeting = mAdapter.getOneMeeting(position);
        DI.getMeetingApiService().deleteMeetings(meeting);
        mAdapter.updateList(DI.getMeetingApiService().getMeetings());

        Toast.makeText(getApplicationContext(), "Vous avez supprimé : " + meeting.getNameOfMeeting(), Toast.LENGTH_SHORT).show();


    }
}
