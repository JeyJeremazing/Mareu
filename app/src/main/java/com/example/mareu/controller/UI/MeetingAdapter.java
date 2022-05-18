package com.example.mareu.controller.UI;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mareu.R;
import com.example.mareu.controller.MeetingDetail;
import com.example.mareu.model.Attendees;
import com.example.mareu.model.Meeting;
import com.example.mareu.model.Rooms;

import java.net.CookieHandler;
import java.util.ArrayList;

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
    public void onBindViewHolder(@NonNull MeetingAdapter.ViewHolder holder, int position) {
        holder.displayMeeting(mMeetings.get(position));

    }

    @Override
    public int getItemCount() {
        return mMeetings.size();

    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public final TextView meetingName;
       // public final TextView hours;
        public final TextView rooms;
        public final TextView attendeesMail;
        //public final TextView deleteButton;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            meetingName = itemView.findViewById(R.id.meeting);
            //hours = itemView.findViewById(R.id.hours);
            rooms = itemView.findViewById(R.id.room);
            attendeesMail = itemView.findViewById(R.id.attendeesMail);
            //deleteButton = itemView.findViewById(R.id.delete_button);


        }
        public void displayMeeting(Meeting meet){
            meetingName.setText(meet.getNameOfMeeting());
            rooms.setText(meet.getRooms());
            attendeesMail.setText(meet.getAttendeesMail());

        }

        }

}
