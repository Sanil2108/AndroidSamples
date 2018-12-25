package sanilk.com.animations;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HidingViewsUsingAnimation extends AppCompatActivity {

    private View loadingView;
    private View container;

    private int mShortAnimationDuration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hiding_views_using_animation);

        container = findViewById(R.id.content);
        loadingView = findViewById(R.id.loading_spinner);

        container.setVisibility(View.GONE);

        mShortAnimationDuration = getResources().getInteger(
                android.R.integer.config_shortAnimTime) * 5;

        Button animateButton = (Button)findViewById(R.id.animateButton);
        animateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animate();
            }
        });

    }

    private void animate(){
        container.setVisibility(View.VISIBLE);
        container.setAlpha(0f);

//        container.animate()
//                .translationX(100)
////                .alpha(1)
//                .setDuration(mShortAnimationDuration)
//                .setListener(null);

        loadingView.animate()
//                .alpha(0f)
                .translationX(200)
                .setDuration(mShortAnimationDuration);
//                .setListener(new AnimatorListenerAdapter() {
//                    @Override
//                    public void onAnimationEnd(Animator animation) {
//                        loadingView.setVisibility(View.GONE);
//                    }
//                });_

    }


}
