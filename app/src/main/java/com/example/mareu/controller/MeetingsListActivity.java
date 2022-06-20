package com.example.mareu.controller;


import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
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
import com.example.mareu.controller.UI.AddMeetingActivity;
import com.example.mareu.controller.UI.MeetingAdapter;
import com.example.mareu.databinding.ActivityMeetingListBinding;
import com.example.mareu.model.Meeting;
import com.example.mareu.service.ItemClickSupport;
import com.example.mareu.service.MeetingApiService;

import java.util.Calendar;


public class MeetingsListActivity extends AppCompatActivity implements MeetingAdapter.Listener {

    ActivityMeetingListBinding binding;
    private MeetingApiService mMeetingApiService = DI.getMeetingApiService();
    private MeetingAdapter mAdapter;


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

        mAdapter = new MeetingAdapter(mMeetingApiService.getMeetings(), this);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(binding.recyclerView.getContext(),
                layoutManager.getOrientation());
        binding.recyclerView.addItemDecoration(dividerItemDecoration);
        binding.recyclerView.setAdapter(mAdapter);
    }

    private void setButton() {
        binding.floatingActionButton.setOnClickListener(v -> {
            if (v == binding.floatingActionButton) {
                startActivity(new Intent(getApplicationContext(), AddMeetingActivity.class));
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initUI();
        configureOnClickRecyclerView();

    }

    //Filter (Date,Rooms and reset)
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

            case R.id.filter_rooms:
                roomsDialog();
                return true;

            case R.id.filter_reset:
                resetFilter();
            default:
                return super.onOptionsItemSelected(item);

        }

    }

    private void roomsDialog() {
        //INSTANTIATE ALERTDIALOG BUILDER
        AlertDialog.Builder myBuilder = new AlertDialog.Builder(MeetingsListActivity.this);
        myBuilder.setTitle("Sélectionner une salle");

        String[] rooms = mMeetingApiService.getRoomsList().toArray(new String[0]);

        myBuilder.setItems(rooms, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int position) {
                String room = rooms[position];
               /*List<Meeting> meetingList = mMeetingApiService.getMeetingFilteredByRoom(room);
               mAdapter.updateList(meetingList);*/
                mAdapter.updateList(mMeetingApiService.getMeetingFilteredByRoom(room));

            }
        });

        AlertDialog dialog = myBuilder.create();
        dialog.show();
    }


    private void resetFilter() {
        mAdapter.updateList(mMeetingApiService.getMeetings());

    }

    private void dateDialog() {
        int selectedYear = 2022;
        int selectedMonth = 5;
        int selectedDayOfMonth = 28;

        // Date Select Listener
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Calendar cal = Calendar.getInstance();
                cal.set(year, month, dayOfMonth);
                mAdapter.updateList(mMeetingApiService.getMeetingsFilteredByDate(cal.getTime()));

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