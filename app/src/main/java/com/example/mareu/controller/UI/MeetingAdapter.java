package com.example.mareu.controller.UI;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mareu.R;
import com.example.mareu.model.Meeting;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class MeetingAdapter extends RecyclerView.Adapter<MeetingAdapter.ViewHolder> {

   private final ArrayList<Meeting> mMeetings;

    public MeetingAdapter(ArrayList<Meeting> meetings)  {
        this.mMeetings = meetings;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent,  int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_meeting,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.displayMeeting(mMeetings.get(position));


    }

    @Override
    public int getItemCount() {
        return mMeetings.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public final TextView meetingName;
        public final TextView rooms;
        public final TextView attendeesMail;
        public final TextView date;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            meetingName = itemView.findViewById(R.id.meeting);
            rooms = itemView.findViewById(R.id.room);
            attendeesMail = itemView.findViewById(R.id.attendeesMail);
            date = itemView.findViewById(R.id.date);

        }

        public void displayMeeting(Meeting meet){
            meetingName.setText(meet.getNameOfMeeting());
            rooms.setText(meet.getRoom());
            attendeesMail.setText(meet.getAttendeesMail());

        }
    }
}
