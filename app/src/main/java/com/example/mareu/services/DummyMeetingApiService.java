package com.example.mareu.services;

import com.example.mareu.model.Meeting;
import com.example.mareu.model.Room;

import java.util.ArrayList;
import java.util.List;

public class DummyMeetingApiService implements MeetingApiService {

    private List<Room> mRooms = RoomGenerator.generateRooms();

    private List <Meeting> meetings =  MeetingGenerator.generateMeetings();

    @Override
    public List<Room> getRooms() {
        return mRooms;
    }

    @Override
    public List<Meeting> getMeetingsList() {
        return meetings;
    }

    @Override
    public void deleteMeeting(Meeting meeting) {

        meetings.remove(meeting);

    }

    @Override
    public void addMeeting(Meeting meeting) {

        meetings.add(meeting);
    }
}
