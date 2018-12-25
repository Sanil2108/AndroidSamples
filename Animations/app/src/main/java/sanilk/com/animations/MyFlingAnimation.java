package sanilk.com.animations;

import android.support.animation.DynamicAnimation;
import android.support.animation.FlingAnimation;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MyFlingAnimation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_fling_animation);

        Button button = findViewById(R.id.activity_my_fling_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new FlingAnimation(v, DynamicAnimation.SCROLL_X)
                        .setStartVelocity(20)
                        .setMinValue(0)
                        .setMaxValue(100)
                        .setFriction(1.1f)
                        .start();
            }
        });

        ImageButton zoomAnimationButton = findViewById(R.id.activity_my_zoom_button);
        zoomAnimationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });

    }
}
