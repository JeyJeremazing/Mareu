package com.example.mareu.controller.UI;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mareu.DI.DI;
import com.example.mareu.R;
import com.example.mareu.model.Meeting;
import java.util.ArrayList;
import java.util.List;

public class MeetingAdapter extends RecyclerView.Adapter<MeetingAdapter.ViewHolder> {

   private List<Meeting> mMeetings;

    public MeetingAdapter(List<Meeting> meetings)  {
        this.mMeetings = meetings;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent,  int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_meeting,parent,false);
        return new ViewHolder(view).linkAdapter(this);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder,final int position) {
        Meeting meetings= mMeetings.get(position);
        holder.displayMeeting(meetings);

    }

    public void updateList(List<Meeting> mMeeting){
        this.mMeetings = mMeeting;
        notifyDataSetChanged();

    }

    @Override
    public int getItemCount() {
        return mMeetings.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private MeetingAdapter adapter;

        public final TextView meetingText;
        public final TextView roomText;
        public final TextView attendeesMailText;
        public final TextView dateText;
        public ImageView mDeleteImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            meetingText = itemView.findViewById(R.id.meetingText);
            roomText = itemView.findViewById(R.id.roomText);
            attendeesMailText = itemView.findViewById(R.id.attendeesMailText);
            dateText = itemView.findViewById(R.id.dateText);
            mDeleteImage = itemView.findViewById(R.id.delete_button);

            mDeleteImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Meeting meeting = adapter.mMeetings.get(getAdapterPosition());
                    DI.getMeetingApiService().deleteMeetings(meeting);
                    adapter.updateList(DI.getMeetingApiService().getMeetings());
                }
            });
        }

        public ViewHolder linkAdapter(MeetingAdapter adapter) {
            this.adapter= adapter;
            return this;
        }

        public void displayMeeting(Meeting meet){
            meetingText.setText(meet.getNameOfMeeting());
            roomText.setText(meet.getRoom());
            attendeesMailText.setText(meet.getAttendeesMail());
            dateText.setText(meet.getDate());
        }
    }
}
