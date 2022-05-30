package com.example.mareu.controller;


import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
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

import java.util.ArrayList;
import java.util.Calendar;


public class MeetingsListActivity extends AppCompatActivity implements MeetingAdapter.Listener {

    ActivityMeetingListBinding binding;
    private MeetingApiService mMeetingApiService = DI.getMeetingApiService();
    private MeetingAdapter mAdapter;
    private ArrayList<Meeting> meetingArrayList = new ArrayList<>();


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

        mAdapter = new MeetingAdapter(meetingArrayList, this);
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
        initData();
        initUI();
        configureOnClickRecyclerView();

    }

    private void initData() {
        meetingArrayList = new ArrayList<>(mMeetingApiService.getMeetings());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.filter_date:
                dateDialog();
                return true;
            case R.id.filter_reset:
                resetFilter();
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    private void resetFilter() {
        meetingArrayList.clear();
        meetingArrayList.addAll(mMeetingApiService.getMeetings());
        binding.recyclerView.getAdapter().notifyDataSetChanged();
    }

    private void dateDialog() {
        int selectedYear =2022;
        int selectedMonth =5;
        int selectedDayOfMonth=28;

        // Date Select Listener
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Calendar cal = Calendar.getInstance();
                cal.set(year,month,dayOfMonth);
                meetingArrayList.clear();
                meetingArrayList.addAll(mMeetingApiService.getMeetingsFilteredByDate(cal.getTime()));
                binding.recyclerView.getAdapter().notifyDataSetChanged();

            }
        };

        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                dateSetListener, selectedYear, selectedMonth, selectedDayOfMonth);

        datePickerDialog.show();
    }


    @Override
    protected void onResume() {
        super.onResume();
        resetFilter();
    }

    private void configureOnClickRecyclerView() {
        ItemClickSupport.addTo(binding.recyclerView, R.layout.item_meeting)
                .setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
                    @Override
                    public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                        Meeting meeting = mAdapter.getOneMeeting(position);
                        Toast.makeText(getApplicationContext(), "Réunion : " + meeting.getNameOfMeeting(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    @Override
    public void onClickDeleteButton(int position) {
        Meeting meeting = mAdapter.getOneMeeting(position);
        DI.getMeetingApiService().deleteMeetings(meeting);
        mAdapter.updateList(DI.getMeetingApiService().getMeetings());


        Toast.makeText(getApplicationContext(), "Vous avez supprimé : " + meeting.getNameOfMeeting(), Toast.LENGTH_SHORT).show();


    }
}