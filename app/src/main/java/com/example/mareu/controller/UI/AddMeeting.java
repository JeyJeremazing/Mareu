package com.example.mareu.controller.UI;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import com.example.mareu.DI.DI;
import com.example.mareu.R;
import com.example.mareu.databinding.ActivityAddMeetingBinding;
import com.example.mareu.databinding.ActivityMeetingListBinding;
import com.example.mareu.databinding.ItemMeetingBinding;
import com.example.mareu.model.Meeting;
import com.example.mareu.service.MeetingApiService;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;


public class AddMeeting extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    ActivityAddMeetingBinding binding;


    private MeetingApiService mMeetingApiService = DI.getMeetingApiService();
    ArrayAdapter<String> adapterItems;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initUI();
        initRooms();

        binding.dateDate.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        DialogFragment datePicker = new DatePickerFragment();
        datePicker.show(getSupportFragmentManager(),"date picker");

    }
});
    }
    //Date
    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR,year);
        c.set(Calendar.MONTH,month);
        c.set(Calendar.DAY_OF_MONTH,dayOfMonth);
        String currentDateString = DateFormat.getDateInstance(DateFormat.SHORT).format(c.getTime());
        binding.displayDate.setText(currentDateString);

    }


    //UI
    private void initUI() {
        binding = ActivityAddMeetingBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        setButton();
        getSupportActionBar().setTitle("Nouvelle Réunion");

    }

    //Rooms
    public List<String> roomList() {
        return mMeetingApiService.getRoomsList();
    }

    public void initRooms() {
        adapterItems = new ArrayAdapter<String>(this, R.layout.list_item_rooms, roomList());
        binding.autoCompleteTxt.setAdapter(adapterItems);
    }


    //Button
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

    private void onCreateButton() {

        String attendeesMail = binding.attendeesMail.getEditText().getText().toString();
        String date = binding.dateDate.getText().toString();
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
        if (room.isEmpty()) {
            binding.room.setError("Choisissez votre Salle!");
            return;
        }

        mMeetingApiService.createMeetings(new Meeting(00, nameOfMeeting, room, attendeesMail));
        Toast.makeText(this, "Réunion créé !", Toast.LENGTH_SHORT).show();
        finish();

    }



}