package com.bartoszlipinski.disableanimationsrule.sample.activity;

import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import com.bartoszlipinski.disableanimationsrule.DisableAnimationsRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(MainActivity.class);

    @Rule
    public DisableAnimationsRule animationsRule = new DisableAnimationsRule();

    @Test
    public void thisTestWill_NOT_workWithAnimations() {
        onView(withText("sample")).check(matches(isDisplayed()));
        onView(withText("Animate")).perform(click());
        onView(withText("something different")).check(matches(isDisplayed()));
    }
}
