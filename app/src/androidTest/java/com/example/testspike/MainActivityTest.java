package com.example.testspike;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.Display;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest {

   @Rule
   public ActivityTestRule<MainActivity> activityRule =
           new ActivityTestRule<>(MainActivity.class);

    @Test
    public void activity_shouldDisplayEmail_whenLaunchMainActivity(){
        onView(withText("My Settings")).check(matches(isDisplayed()));
        onView(withText("Your name:")).check(matches(isDisplayed()));
        onView(withText("Your date of birth:")).check(matches(isDisplayed()));
        onView(withText("Your email address:")).check(matches(isDisplayed()));

        onView(withId(R.id.userNameInput)).check(matches(isDisplayed()));
        onView(withId(R.id.dateOfBirthInput)).check(matches(isDisplayed()));
        onView(withId(R.id.emailInput)).check(matches(isDisplayed()));
        onView(withId(R.id.saveButton)).check(matches(isDisplayed()));
        onView(withId(R.id.revertButton)).check(matches(isDisplayed()));
    }
}
