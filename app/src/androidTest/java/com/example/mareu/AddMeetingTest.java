package com.example.mareu;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.PickerActions.setDate;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static androidx.test.espresso.matcher.ViewMatchers.withChild;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsAnything.anything;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.StringContains.containsString;

import android.widget.DatePicker;

import androidx.test.espresso.matcher.RootMatchers;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import com.example.mareu.controller.UI.AddMeetingActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class AddMeetingTest {
    private AddMeetingActivity mActivity;

    @Rule

    public ActivityTestRule<AddMeetingActivity> mActivityRule =
            new ActivityTestRule(AddMeetingActivity.class);

    @Before

    public void setUp() {
        mActivity = mActivityRule.getActivity();
        assertThat(mActivity, notNullValue());
    }

    @Test
    public void checkIfMailAddressIsWritten() {
        //check that the Edit Text contains no String
        onView(withId(R.id.attendeesMailEdiText)).check(matches(withText(containsString(("")))));
        //Type a fake mail address
        onView(withId(R.id.attendeesMailEdiText)).perform((typeText("jeremy.m@coucou.fr")));
        //Then check if the mail address was typed
        onView(withId(R.id.attendeesMailEdiText)).check(matches(withText(containsString(("jeremy.m@coucou.fr")))));

    }

    @Test
    public void meetingThemeIsWritten() {
        //check that the Edit Text contains no String
        onView(withId(R.id.meetingEditText)).check(matches(withText(containsString(("")))));
        //Type a fake meeting theme
        onView(withId(R.id.meetingEditText)).perform((typeText("CHIFFRE D'AFFAIRE")));
        //Then check if the meeting theme was typed
        onView(withId(R.id.meetingEditText)).check(matches(withText(containsString(("CHIFFRE D'AFFAIRE")))));

    }

    @Test
    public void chooseADate() {
        //click on the button
        onView(withId(R.id.dateDate)).perform(click());
        //set the date
        onView(isAssignableFrom(DatePicker.class)).perform(setDate(2022, 03, 16));
        onView(withId(android.R.id.button1)).perform(click());

        onView(withId(R.id.displayDate)).check(matches(withText(containsString(("16-03-2022")))));

    }

    @Test
    public void chooseARoom() {
        onView(withId(R.id.auto_complete_txt)).perform(scrollTo()).perform(click());
        onView(withText("Yoda"))
                .inRoot(withDecorView(not(is(mActivity.getWindow().getDecorView()))))
                .perform(click());
    }

}
