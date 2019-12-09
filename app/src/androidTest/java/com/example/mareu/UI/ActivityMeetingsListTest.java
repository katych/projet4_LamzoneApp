package com.example.mareu.UI;

import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import com.example.mareu.R;
import com.example.mareu.utils.DeleteViewAction;
import com.example.mareu.utils.RecyclerViewItemCountAssertion;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasMinimumChildCount;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.notNullValue;

@RunWith(AndroidJUnit4.class)

public class ActivityMeetingsListTest {

    private ActivityMeetingsList mActivityMeetingsList;
    private static int ITEMS_COUNT = 3 ;

    @Rule
    ActivityTestRule<ActivityMeetingsList>mActivityTestRule =
            new ActivityTestRule<>(ActivityMeetingsList.class);


    @Before
    public void setUp() {
        mActivityMeetingsList = mActivityTestRule.getActivity();
        assertThat(mActivityMeetingsList, notNullValue());
    }

    // check Meeting list is not empty

   @Test

    public void reunionList_shouldNotBeEmpty(){

        onView(withId(R.id.meetings_list))
                .check(matches(hasMinimumChildCount(1)));

   }

   // Delete meeting

   @Test
   public void check_deleteButton(){
       onView(withId(R.id.meetings_list)).check(matches(isDisplayed()));
        onView(withId(R.id.meetings_list)).perform(RecyclerViewActions.actionOnItemAtPosition(0,new DeleteViewAction()));
        onView(withId(R.id.meetings_list)).check(RecyclerViewItemCountAssertion.withItemCount(ITEMS_COUNT - 1));

   }

   // click to add a meeting

    @Test

    public void check_clickToAddMeeting(){

        onView(withId(R.id.meetings_list)).check(matches(isDisplayed()));
        onView(withId(R.id.btnFab)).perform(click());
        onView(withId(R.id.create_meeting)).check(matches(isDisplayed()) );

    }

    // Check button add meeting


    @Test
    public void Check_button_add_meeting(){

        onView(withId(R.id.meetings_list)).check(matches(isDisplayed()));
        onView(withId(R.id.btnFab)).perform(click());
        onView(withId(R.id.subject)).perform(replaceText("Test"));
        onView(withId(R.id.text_add_mail)).perform(replaceText("Test"));
        onView(withId(R.id.btn_add_meeting)).perform(click());
        onView(withId(R.id.meetings_list)).check(RecyclerViewItemCountAssertion.withItemCount(ITEMS_COUNT + 1));

    }



}