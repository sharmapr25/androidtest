package com.example.testspike;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.Calendar;
import java.util.Objects;

class SharedPreferenceEntry {

    public String getName() {
        return name;
    }

    public Calendar getDateOfBirth() {
        return dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    private final String name;
    private final Calendar dateOfBirth;
    private final String email;

    public SharedPreferenceEntry(String name, Calendar dateOfBirth, String email) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SharedPreferenceEntry that = (SharedPreferenceEntry) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (dateOfBirth != null ? !dateOfBirth.equals(that.dateOfBirth) : that.dateOfBirth != null)
            return false;
        return email != null ? email.equals(that.email) : that.email == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (dateOfBirth != null ? dateOfBirth.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }
}
