package com.example.mareu.controller.UI;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.mareu.DI.DI;
import com.example.mareu.R;
import com.example.mareu.databinding.ActivityAddMeetingBinding;
import com.example.mareu.model.Meeting;
import com.example.mareu.model.Room;
import com.example.mareu.service.MeetingApiService;

public class AddMeeting extends AppCompatActivity implements View.OnClickListener {

    ActivityAddMeetingBinding binding;
   private MeetingApiService mMeetingApiService = DI.getMeetingApiService();

   private void initUI(){
       binding=ActivityAddMeetingBinding.inflate(getLayoutInflater());
       View view = binding.getRoot();
       setContentView(view);
       setButton();
       getSupportActionBar().setTitle("New Réunion");
   }
   private void setButton() {binding.createMeetingButton.setOnClickListener(this);}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_meeting);
        initUI();
    }

    @Override
    public void onClick(View v) {
       if(v == binding.createMeetingButton){
           onCreateButton();
       }
    }

    private void  onCreateButton(){
       String mail = binding.attendeesMail.getEditText().getText().toString();
       String date = binding.date.getEditText().getText().toString();
       String meeting = binding.meeting.getEditText().getText().toString();
       String room = binding.room.getEditText().getText().toString();

        if (mail.isEmpty()){
           binding.attendeesMail.setError("Taper votre adresse mail");
           return;
        }
        if (date.isEmpty()){
            binding.date.setError("Choissisez la date");
            return;
        }
        if (meeting.isEmpty()){
            binding.meeting.setError("Taper le thème de votre réunion");
            return;
        }
        if (room.isEmpty()){
            binding.room.setError("Taper la salle ou aura lieu la réunion");
            return;
        }

        mMeetingApiService.createMeetings(new Meeting(mail,meeting,room));
        Toast.makeText(this,"Réunion crée !", Toast.LENGTH_SHORT).show();
        finish();
    }
}