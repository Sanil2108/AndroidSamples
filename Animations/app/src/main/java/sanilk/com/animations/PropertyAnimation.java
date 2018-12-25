package sanilk.com.animations;

import android.animation.ObjectAnimator;
import android.graphics.Path;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.PathInterpolator;
import android.widget.Button;

public class PropertyAnimation extends AppCompatActivity {
    Button btn;

    int temp = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_animation);

        btn = findViewById(R.id.activity_property_animations_button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("ABCD", "AB");
                animate(v);
            }
        });

        Button btn2 = findViewById(R.id.activity_property_animations_button2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("ABCD", "AB");
                animate2(v);
            }
        });
    }


    private void animate(View v){
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(v, "rotation", temp);
        temp+=200;
        objectAnimator.setDuration(100);
        objectAnimator.start();
    }

    private void animate2(View v){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Path path = new Path();
            path.arcTo(0f, 0f, 1f, 1f, 270f, -180f, true);
            PathInterpolator pathInterpolator = new PathInterpolator(path);
            ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(v, "translationX", 100f);
            objectAnimator.setInterpolator(pathInterpolator);
            objectAnimator.start();
        }

    }
}
