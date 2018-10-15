package com.bartoszlipinski.disableanimationsrule.sample.activity;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.bartoszlipinski.disableanimationsrule.DisableAnimationsRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static cortado.Cortado.onButton;
import static cortado.Cortado.onTextView;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(MainActivity.class);

    @Rule
    public DisableAnimationsRule animationsRule = new DisableAnimationsRule();

    @Test
    public void thisTestWill_NOT_workWithAnimations() {
        onTextView().withText("sample").check().matches(isDisplayed());
        onButton().withText("Animate").perform().click();
        onTextView().withText("something different").check().matches(isDisplayed());
    }
}
