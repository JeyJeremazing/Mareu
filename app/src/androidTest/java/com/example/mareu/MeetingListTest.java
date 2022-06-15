package com.example.mareu;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.hasMinimumChildCount;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static com.example.mareu.RecyclerViewItemCountAssertion.withItemCount;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import com.example.mareu.controller.MeetingsListActivity;

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
        onView(ViewMatchers.withId(R.id.recyclerView)).check(matches(hasMinimumChildCount(1)));
}

    @Test
    public void removeMeetingItem() {
        onView(ViewMatchers.withId(R.id.recyclerView)).check(withItemCount(ITEMS_COUNT));
        onView(ViewMatchers.withId(R.id.recyclerView))
                .perform(actionOnItemAtPosition(1, new DeleteViewAction()));
        onView(ViewMatchers.withId(R.id.recyclerView)).check(withItemCount(ITEMS_COUNT-1));
    }

    @Test
    public void clickForLaunchTheAddMeetingActivityScreen() {
        onView(withId(R.id.floatingActionButton)).perform((click()));
        onView(ViewMatchers.withId(R.id.addMeeting)).check(matches(isDisplayed()));
    }





}
