package com.example.mareu.UI;

import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.notNullValue;


public class ActivityMeetingsListTest {

    private ActivityMeetingsList mActivityMeetingsList;

    @Rule
    ActivityTestRule<ActivityMeetingsList>mActivityTestRule =
            new ActivityTestRule<>(ActivityMeetingsList.class);


    @Before
    public void setUp() {
        mActivityMeetingsList = mActivityTestRule.getActivity();
        assertThat(mActivityMeetingsList, notNullValue());

    }
}