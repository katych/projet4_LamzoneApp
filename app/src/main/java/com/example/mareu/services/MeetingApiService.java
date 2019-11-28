package com.example.mareu.services;

import com.example.mareu.model.Meeting;
import com.example.mareu.model.Room;

import java.util.ArrayList;
import java.util.List;

public interface MeetingApiService {


List<Room> getRooms ();

List<Meeting> getMeetingsList() ;


void deleteMeeting(Meeting meeting);

void addMeeting(Meeting meeting);


}
