package com.example.mareu;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.PickerActions.setDate;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.hasMinimumChildCount;
import static androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static com.example.mareu.utils.UI.RecyclerViewItemCountAssertion.withItemCount;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;

import android.widget.DatePicker;

import androidx.test.espresso.intent.Intents;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import com.example.mareu.controller.MeetingsListActivity;
import com.example.mareu.controller.UI.AddMeetingActivity;
import com.example.mareu.utils.UI.DeleteViewAction;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class MeetingListTest {

    private final static int ITEMS_COUNT = 7;

    private MeetingsListActivity mActivity;

    @Rule

    public ActivityTestRule<MeetingsListActivity> mActivityRule =
            new ActivityTestRule(MeetingsListActivity.class);

    @Before

    public void setUp() {
        mActivity = mActivityRule.getActivity();
        assertThat(mActivity, notNullValue());
    }

    @Test
    public void checkTheListIsNotEmpty() {
        onView(ViewMatchers.withId(R.id.recyclerView)).check(withItemCount(ITEMS_COUNT));
    }

    @Test
    public void removeMeetingItem() {
        onView(ViewMatchers.withId(R.id.recyclerView)).check(withItemCount(ITEMS_COUNT));
        onView(ViewMatchers.withId(R.id.recyclerView))
                .perform(actionOnItemAtPosition(1, new DeleteViewAction()));
        onView(ViewMatchers.withId(R.id.recyclerView)).check(withItemCount(ITEMS_COUNT - 1));
    }

    @Test
    public void clickForLaunchTheAddMeetingActivityScreen() {
        onView(withId(R.id.floatingActionButton)).perform((click()));
        onView(ViewMatchers.withId(R.id.addMeeting)).check(matches(isDisplayed()));
    }

    @Test
    public void addMeeting (){
        //Open AddMeeting
        onView(withId(R.id.floatingActionButton)).perform((click()));
        //Fill the EditTexts
        onView(withId(R.id.attendeesMailEdiText)).perform((typeText("jeremy.m@coucou.fr")));
        onView(withId(R.id.meetingEditText)).perform((typeText("CHIFFRE D'AFFAIRE")));
        //Set Date
        onView(withId(R.id.dateDate)).perform(click());
        onView(isAssignableFrom(DatePicker.class)).perform(setDate(2022, 03, 16));
        onView(withId(android.R.id.button1)).perform(click());
        //Choose the room
        onView(withId(R.id.auto_complete_txt)).perform(scrollTo()).perform(click());
        onView(withText("Yoda"))
                .inRoot(withDecorView(not(is(mActivity.getWindow().getDecorView()))))
                .perform(click());
        //Close the keyboards
        onView(withId(R.id.room)).perform(closeSoftKeyboard());
        //Click on the button for add our new Meeting
        onView(withId(R.id.createMeetingButton)).perform(click());
        //Then check the new meeting is created
        onView(ViewMatchers.withId(R.id.recyclerView)).check(withItemCount(ITEMS_COUNT + 1));

    }
    @Test
    public void dateFilterIsWorking(){

    }
}
