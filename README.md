# Intoduction:
This is a directory for learning **how to test android ui and logic** for beginner.
It is a simple android app on page it shows three fields as given below:
<Name>
<Date of birth>
<Email>

It has two actions: 
* save  (use to save given information)
* revert (rest current information to previous state)

# Get Started
before start: there is an assumption of little bit familiarity with android and how to create a simple android app.

### Prerequisite
```
> android studio 3.4.1 or above
```

### Directory structure
![Androidtest](https://github.com/piolAtif/androidtest/blob/master/Screen%20Shot%202019-09-19%20at%209.18.41%20AM.png)
![test](https://github.com/piolAtif/androidtest/blob/master/Screen%20Shot%202019-09-19%20at%209.18.57%20AM.png)

In **main** directory there are four files:
* EmailValidator.java -> To Validate given email
* MainActivity.java -> Main activity that will allow input to save or not
* SharedPreferenceEntry.java -> Person info model
* SharedPreferencesHelper.java -> A helper who will save person info in shared preference.

Here it has two test directories:
* test/ -> test the logic for validation and saving.
* androidTest/ -> test the ui with several action.
```
If you notice this directory has separated tests into two places. It is recommended to write logic and ui tests separately
```
**Levels of the Testing Pyramid**
![levels in android testing](https://github.com/piolAtif/androidtest/blob/master/Screen%20Shot%202019-09-19%20at%203.23.59%20PM.png)
* Small tests are unit tests that validate your app's behavior one class at a time.
* Medium tests are integration tests that validate either interactions between levels of the stack within a module, or interactions between related modules.
* Large tests are end-to-end tests that validate user journeys spanning multiple modules of your app.

#### Testing approach
##### Unit test:
EmailValidatorTest = this test file has all test scenerios related to email validation.
SharedPreferencesHelperTest = this test file use sharedPreference as mocking and test all scenerio of saving and fetching the data from [sharedPreference](https://developer.android.com/training/data-storage/shared-preferences)


##### UI test:
For ui testing this directory used [espresso](https://developer.android.com/training/testing/espresso). Espresso is well known testing framework for android ui testing.

### How to run test:
In android studio it is a quick click button to run all tests.

### Other cool stuff:
* [espresso test recorder](https://developer.android.com/studio/test/espresso-test-recorder)
* [Appium vs. Espresso](https://saucelabs.com/blog/appium-vs-espresso)

### References
* https://developer.android.com/training/data-storage/shared-preferences
* https://medium.com/mindorks/learn-unit-testing-in-android-by-building-a-sample-application-23ec2f6340e8
* https://developer.android.com/training/testing/espresso/basics
* https://developer.android.com/guide/components/activities/testing
* https://developer.android.com/training/testing/ui-testing/espresso-testing
