package com.example.mareu.controller.UI;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.mareu.R;
import com.example.mareu.model.Meeting;
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
    public void onBindViewHolder(@NonNull ViewHolder holder,final int position) {
        Meeting meetings= mMeetings.get(position);
        holder.displayMeeting(meetings);


    }

    @Override
    public int getItemCount() {
        return mMeetings.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public final TextView meetingText;
        public final TextView roomText;
        public final TextView attendeesMailText;
        public final TextView dateText;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            meetingText = itemView.findViewById(R.id.meetingText);
            roomText = itemView.findViewById(R.id.roomText);
            attendeesMailText = itemView.findViewById(R.id.attendeesMailText);
            dateText = itemView.findViewById(R.id.dateText);
        }

        public void displayMeeting(Meeting meet){
            meetingText.setText(meet.getNameOfMeeting());
            roomText.setText(meet.getRoom());
            attendeesMailText.setText(meet.getAttendeesMail());
            dateText.setText(meet.getDate());
        }
    }
}
