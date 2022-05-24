package com.example.mareu.controller.UI;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.mareu.DI.DI;
import com.example.mareu.databinding.ActivityAddMeetingBinding;
import com.example.mareu.model.Meeting;
import com.example.mareu.service.MeetingApiService;



public class AddMeeting extends AppCompatActivity implements View.OnClickListener {

    ActivityAddMeetingBinding binding;
    private MeetingApiService mMeetingApiService = DI.getMeetingApiService();

    private void initUI() {
        binding = ActivityAddMeetingBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        setButton();
        getSupportActionBar().setTitle("Nouvelle Réunion");

    }

    private void setButton() {
        binding.createMeetingButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == binding.createMeetingButton) {
            onCreateButton();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initUI();
    }
    private void  onCreateButton(){
        String attendeesMail = binding.attendeesMail.getEditText().getText().toString();
        String date = binding.date.getEditText().getText().toString();
        String nameOfMeeting = binding.meeting.getEditText().getText().toString();
        String room = binding.room.getEditText().getText().toString();

        if (attendeesMail.isEmpty()){
            binding.attendeesMail.setError("Taper votre adresse mail");
            return;
        }
        if (nameOfMeeting.isEmpty()){
            binding.meeting.setError("Taper le thème de votre réunion");
            return;
        }
        if (date.isEmpty()){
            binding.date.setError("Choissisez la date");
            return;
        }
        if (room.isEmpty()){
            binding.room.setError("Taper la salle ou aura lieu la réunion");
            return;
        }
        mMeetingApiService.createMeetings(new Meeting(nameOfMeeting,room,attendeesMail,date));
        Toast.makeText(this,"Réunion créé !", Toast.LENGTH_SHORT).show();
        finish();

    }
}