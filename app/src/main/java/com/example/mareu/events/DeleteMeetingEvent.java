package com.example.mareu.events;

import android.util.Log;

import com.example.mareu.model.Meeting;

public class DeleteMeetingEvent {

    public Meeting meeting ;


    public DeleteMeetingEvent(Meeting meeting) {
        Log.d("DEBUG", "DeleteMeetingEvent: Delete Meeting from meetings list");

        this.meeting = meeting;
    }
}
