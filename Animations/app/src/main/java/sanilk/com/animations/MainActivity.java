package sanilk.com.animations;

import android.content.Context;
import android.content.Intent;
import android.support.animation.FlingAnimation;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.context = this;

        Button vectorAnimationButton = (Button)findViewById(R.id.activity_main_vector_animation);
        vectorAnimationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, VectorAnimation.class);
                startActivity(intent);
            }
        });

        Button crossfadeButton = (Button)findViewById(R.id.activity_main_crossfade_animation);
        crossfadeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, HidingViewsUsingAnimation.class);
                startActivity(intent);
            }
        });

        Button properyAnimationButton = (Button)findViewById(R.id.activity_main_property_animator);
        properyAnimationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PropertyAnimation.class);
                startActivity(intent);
            }
        });

        Button flingAnimationButton = (Button)findViewById(R.id.activity_main_fling_animation);
        flingAnimationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MyFlingAnimation.class);
                startActivity(intent);
            }
        });

        Button layoutChangesButton = (Button)findViewById(R.id.activity_main_layout_changes);
        layoutChangesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, LayoutChanges.class);
                startActivity(intent);
            }
        });
    }
}
