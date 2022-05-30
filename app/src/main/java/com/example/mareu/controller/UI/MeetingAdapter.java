package com.example.mareu.controller.UI;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mareu.R;
import com.example.mareu.model.Meeting;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class MeetingAdapter extends RecyclerView.Adapter<MeetingAdapter.ViewHolder> {

    public interface Listener {
        void onClickDeleteButton(int position);
    }

    public final Listener callback;

    private List<Meeting> mMeetings;

    public MeetingAdapter(ArrayList<Meeting> meetings, Listener callback) {
        this.mMeetings = meetings;
        this.callback = callback;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_meeting, parent, false);
        return new ViewHolder(view).linkAdapter(this);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        holder.displayMeeting(this.mMeetings.get(position), callback);

    }

    public void updateList(List<Meeting> mMeeting) {
        this.mMeetings = mMeeting;
        notifyDataSetChanged();

    }

    @Override
    public int getItemCount() {
        return mMeetings.size();
    }

    public Meeting getOneMeeting(int position) {
        return this.mMeetings.get(position);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
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
        }

        public ViewHolder linkAdapter(MeetingAdapter adapter) {
            this.adapter = adapter;
            return this;
        }

        public void displayMeeting(Meeting meeting, Listener callback) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

            meetingText.setText(meeting.getNameOfMeeting());
            roomText.setText(meeting.getRoom());
            attendeesMailText.setText(meeting.getAttendeesMail());
            dateText.setText(simpleDateFormat.format(meeting.getDate()));


            this.mDeleteImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (callback != null) callback.onClickDeleteButton(getAdapterPosition());
                }
            });
        }
    }
}