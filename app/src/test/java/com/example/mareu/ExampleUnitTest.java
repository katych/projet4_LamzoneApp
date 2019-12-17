package com.example.mareu;


import com.example.mareu.UI.ActivityMeetingsList;
import com.example.mareu.di.DI;
import com.example.mareu.model.Meeting;
import com.example.mareu.services.MeetingApiService;
import com.example.mareu.services.MeetingGenerator;
import com.example.mareu.services.RoomGenerator;
import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.junit.Before;
import org.junit.Test;
import java.util.Collections;
import java.util.List;
import static org.junit.Assert.*;

public class ExampleUnitTest {


    private MeetingApiService service ;

    @Before
    public void setup() {
        service = DI.getNewInstanceApiService();
    }


    @Test
    public void getMeetingsList() {

        List<Meeting> mMeetings = service.getMeetingsList();

        List<Meeting> expectedMeetings = MeetingGenerator.meetingList;
        assertThat(mMeetings, IsIterableContainingInAnyOrder.containsInAnyOrder(expectedMeetings.toArray()));

    }


    @Test
    public void addMeetingWithSuccess() {

        Meeting meeting = new Meeting("Reunion 4 ", RoomGenerator.generateRooms().get(4), "09", "Mer 20",
                "david@lamzone.com");
        service.addMeeting(meeting);
        assertTrue(service.getMeetingsList().contains(meeting));

    }

    @Test
    public void deleteReunionWithSuccess() {
        Meeting meetingToDelete = service.getMeetingsList().get(0);
        service.deleteMeeting(meetingToDelete);
        assertFalse(service.getMeetingsList().contains(meetingToDelete));
    }


    @Test
    public void FilterRooms() {

        Meeting meeting = new Meeting("Reunion 4 ", RoomGenerator.generateRooms().get(4), "09", "Mer 20",
                "david@lamzone.com ");
        service.addMeeting(meeting);
        Collections.sort(service.getMeetingsList(), new ActivityMeetingsList.ComparatorRooms());
    }

    @Test
    public void FilterDate() {

        Meeting meeting = new Meeting("Reunion 4 ", RoomGenerator.generateRooms().get(4), "09", "Mer 20",
                "david@lamzone.com ");
        service.addMeeting(meeting);
        Collections.sort(service.getMeetingsList(), new ActivityMeetingsList.ComparatorDate());
    }

}