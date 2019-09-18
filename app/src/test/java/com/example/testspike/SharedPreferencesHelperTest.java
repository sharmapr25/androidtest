package com.example.testspike;

import android.content.SharedPreferences;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Calendar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SharedPreferencesHelperTest {
    final String KEY_NAME = "key_name";
    final String KEY_DOB = "key_dob_millis";
    final String KEY_EMAIL = "key_email";

    @Mock
    SharedPreferences sharedPreferences;

    @Mock
    SharedPreferences.Editor sharePreferenceEditor;

    @Test
    public void savePersonalInfo_expectSaveInfo_whenGivenSharedPreferenceEntryHasAllValues() {
        SharedPreferenceEntry sharedPreferenceEntry = new SharedPreferenceEntry("name", Calendar.getInstance(), "name@gmail.com");
        SharedPreferencesHelper sharedPreferencesHelper = new SharedPreferencesHelper(sharedPreferences);

        when(sharedPreferences.edit()).thenReturn(sharePreferenceEditor);

        sharedPreferencesHelper.savePersonalInfo(sharedPreferenceEntry);
    }

    @Test(expected = NullPointerException.class)
    public void savePersonalInfo_expectNotSaveInfo_whenGivenSharedPreferenceEntryHasNullDateOfBirth() {
        SharedPreferenceEntry sharedPreferenceEntry = new SharedPreferenceEntry("name", null, "name@gmail.com");
        SharedPreferencesHelper sharedPreferencesHelper = new SharedPreferencesHelper(sharedPreferences);

        when(sharedPreferences.edit()).thenReturn(sharePreferenceEditor);

        sharedPreferencesHelper.savePersonalInfo(sharedPreferenceEntry);
    }

    @Test
    public void getPersonalInfo_expectReturnInfo_whenGivenSharedPreferenceSavedAllEntry() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2018, 2, 12);

        long timeInMillis = calendar.getTimeInMillis();

        SharedPreferencesHelper sharedPreferencesHelper = new SharedPreferencesHelper(sharedPreferences);
        SharedPreferenceEntry expectedSharedPreferenceEntry = new SharedPreferenceEntry("name112", calendar, "name@gmail.com");

        when(sharedPreferences.getString(KEY_NAME, "")).thenReturn("name112");
        when(sharedPreferences.getLong(eq(KEY_DOB), anyLong())).thenReturn(timeInMillis);
        when(sharedPreferences.getString(KEY_EMAIL, "")).thenReturn("name@gmail.com");

        SharedPreferenceEntry sharedPreferenceEntry = sharedPreferencesHelper.getPersonalInfo();

        assertEquals(sharedPreferenceEntry, expectedSharedPreferenceEntry);
    }

    @Test
    public void getPersonalInfo_expectReturnNullInfo_whenGivenSharedPreferenceNotSavedAllEntry() {
        SharedPreferencesHelper sharedPreferencesHelper = new SharedPreferencesHelper(sharedPreferences);

        SharedPreferenceEntry sharedPreferenceEntry = sharedPreferencesHelper.getPersonalInfo();

        assertNull(sharedPreferenceEntry.getName());
        assertNull(sharedPreferenceEntry.getEmail());
    }

}