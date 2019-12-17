package com.example.mareu.services;

import com.example.mareu.R;
import com.example.mareu.model.Meeting;
import com.example.mareu.model.Room;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MeetingGenerator {


    public static List<Meeting> meetingList = Arrays.asList(

            new Meeting("Reunion1", RoomGenerator.generateRooms().get(0), "14h", "Nov 12,2020", " olivier@lamzone.com,paul@lamzone.com,sara@lamzone.com"),
            new Meeting("Reunion2", RoomGenerator.generateRooms().get(1), "15h","Jan 13,2020",  "katy@lamzone.com,paul@lamzone.com,sara@lamzone.com"),
            new Meeting("Reunion3", RoomGenerator.generateRooms().get(2), "16h", "Mar 14,2020", "katy@lamzone.com,paul@lamzone.com,sara@lamzone.com")
    );

    static List<Meeting> generateMeetings() {
        return new ArrayList<>(meetingList);
    }

}
