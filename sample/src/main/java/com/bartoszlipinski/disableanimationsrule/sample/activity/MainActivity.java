package com.bartoszlipinski.disableanimationsrule.sample.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.bartoszlipinski.disableanimationsrule.sample.R;

/**
 * Created by Bartosz Lipinski
 */
public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setEnabled(false);
                startAnimation();
            }
        });
    }

    private void startAnimation() {
        final TextView text = findViewById(R.id.text);
        text.animate()
                .scaleY(2f)
                .setDuration(2000)
                .setStartDelay(500)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        text.setText(getString(R.string.something_different));
                    }
                })
                .start();
    }
}
