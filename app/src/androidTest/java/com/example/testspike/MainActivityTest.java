package com.example.testspike;

import android.support.test.espresso.contrib.PickerActions;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;


@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> activityRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void activity_shouldDisplayEmail_whenLaunchMainActivity() {
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

    @Test
    public void onSaveClick_shouldSaveInformation_whenGivenEmailAndOtherInfoAreValid() {
        onView(withId(R.id.userNameInput)).perform(clearText(), typeText("preeti"));
        onView(withId(R.id.dateOfBirthInput)).perform(PickerActions.setDate(2019, 11, 23));
        onView(withId(R.id.emailInput)).perform(scrollTo(), click(), clearText(), typeText("name1@gmail.com"));
        onView(withId(R.id.saveButton)).perform(scrollTo(), click());

        isToastDisplayed(R.string.saved_message);
    }

    @Test
    public void onRevertClick_shouldReturnMessageOfRevertAndReturnToPreviousState_whenTryToModifyEmailAfterSavingInfo() throws InterruptedException {
        onView(withId(R.id.userNameInput)).perform(clearText(), typeText("preeti"));
        onView(withId(R.id.dateOfBirthInput)).perform(PickerActions.setDate(2019, 11, 23));
        onView(withId(R.id.emailInput)).perform(scrollTo(), click(), clearText(), typeText("name1@gmail.com"));
        onView(withId(R.id.saveButton)).perform(scrollTo(), click());

        Thread.sleep(2000);
        onView(withId(R.id.emailInput)).perform(scrollTo(), click(), clearText(), typeText("name2@gmail.com"));

        onView(withId(R.id.revertButton)).perform(scrollTo(), click());

        isToastDisplayed(R.string.revert_message);

        onView(withId(R.id.emailInput)).check(matches(withText("name1@gmail.com")));

    }

    private void isToastDisplayed(int toast_message) {
        onView(withText(toast_message))
                .inRoot(
                        withDecorView(
                                not(is(activityRule.getActivity().getWindow().getDecorView()))))
                .check(matches(isDisplayed()));
    }
}
