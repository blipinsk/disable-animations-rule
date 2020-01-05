/*
 * Copyright 2018 Bartosz Lipinski
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.bartoszlipinski.disableanimationsrule;

import android.app.UiAutomation;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.uiautomator.UiDevice;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import java.io.IOException;

public class DisableAnimationsRule implements TestRule {

    private static int DISABLED = 0;
    private static int ENABLED = 1;
    private static String TRANSITION_ANIMATION_SCALE = "settings put global transition_animation_scale %d";
    private static String WINDOW_ANIMATION_SCALE = "settings put global window_animation_scale %d";
    private static String ANIMATOR_DURATION_SCALE = "settings put global animator_duration_scale %d";

    @Override
    public Statement apply(final Statement base, Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                disableAnimations();
                try {
                    base.evaluate();
                } finally {
                    enableAnimations();
                }
            }
        };
    }

    private void disableAnimations() throws IOException {
        UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
                .executeShellCommand(String.format(TRANSITION_ANIMATION_SCALE, DISABLED));
        UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
                .executeShellCommand(String.format(WINDOW_ANIMATION_SCALE, DISABLED));
        UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
                .executeShellCommand(String.format(ANIMATOR_DURATION_SCALE, DISABLED));
    }

    private void enableAnimations() throws IOException {
        UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
                .executeShellCommand(String.format(TRANSITION_ANIMATION_SCALE, ENABLED));
        UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
                .executeShellCommand(String.format(WINDOW_ANIMATION_SCALE, ENABLED));
        UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
                .executeShellCommand(String.format(ANIMATOR_DURATION_SCALE, ENABLED));
    }
}