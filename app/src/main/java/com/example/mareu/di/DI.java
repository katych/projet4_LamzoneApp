package com.example.mareu.di;

import com.example.mareu.services.DummyMeetingApiService;
import com.example.mareu.services.MeetingApiService;

public class DI {
    private static MeetingApiService service =  new DummyMeetingApiService();

    /**
     * Get an instance on @{@link MeetingApiService}
     * @return
     */
    public static MeetingApiService getMeetingApiService() {
        return service;
    }

    /**
     * Get always a new instance on @{@link MeetingApiService}. Useful for tests, so we ensure the context is clean.
     * @return
     */
    public static MeetingApiService getNewInstanceApiService() {

        return new DummyMeetingApiService();
    }

}
