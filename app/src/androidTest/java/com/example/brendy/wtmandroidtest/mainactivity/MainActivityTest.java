package com.example.brendy.wtmandroidtest.mainactivity;

import android.content.Intent;
import android.support.test.espresso.action.ViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.brendy.wtmandroidtest.MainActivity;
import com.example.brendy.wtmandroidtest.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by brendy on 4/6/18.
 */

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule<>(MainActivity.class);

    public void prepIntent() {
        Intent intent = new Intent();
        intent.putExtra("EXTRA", "Test");
        mActivityRule.launchActivity(intent);
    }

    @Test
    public void ensureAllViewsAreValid() {
        prepIntent();
        onView(withId(R.id.layout)).check(matches(isDisplayed()));
        onView(withId(R.id.name)).perform(ViewActions.typeText("John Doe"));
        onView(withId(R.id.email)).perform(ViewActions.typeText("johndoe@gmail.com"));
        onView(withId(R.id.btn_done)).perform(ViewActions.click());
    }
}
