package com.example.mareu.controller.UI;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mareu.DI.DI;
import com.example.mareu.R;
import com.example.mareu.databinding.ActivityAddMeetingBinding;
import com.example.mareu.model.Meeting;
import com.example.mareu.service.MeetingApiService;

import java.util.ArrayList;
import java.util.List;


public class AddMeeting extends AppCompatActivity {

    ActivityAddMeetingBinding binding;
    private MeetingApiService mMeetingApiService = DI.getMeetingApiService();
    ArrayAdapter<String> adapterItems;


    public List<String> roomList() {
        return mMeetingApiService.getRoomsList();
    }

    public void initRooms() {
        adapterItems = new ArrayAdapter<String>(this, R.layout.list_item_rooms, roomList());
        binding.autoCompleteTxt.setAdapter(adapterItems);
    }

    private void initUI() {
        binding = ActivityAddMeetingBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        setButton();
        getSupportActionBar().setTitle("Nouvelle Réunion");

    }

    private void setButton() {
        binding.createMeetingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v == binding.createMeetingButton) {
                    onCreateButton();
                }
            }
        });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initUI();
        initRooms();
    }

    private void onCreateButton() {

        String attendeesMail = binding.attendeesMail.getEditText().getText().toString();

        String nameOfMeeting = binding.meeting.getEditText().getText().toString();
        String room = binding.room.getEditText().getText().toString();


        if (attendeesMail.isEmpty()) {
            binding.attendeesMail.setError("Taper votre adresse mail");
            return;
        }
        if (nameOfMeeting.isEmpty()) {
            binding.meeting.setError("Taper le thème de votre réunion");
            return;
        }


        mMeetingApiService.createMeetings(new Meeting(00, nameOfMeeting, room, attendeesMail));
        Toast.makeText(this, "Réunion créé !", Toast.LENGTH_SHORT).show();
        finish();

    }


}