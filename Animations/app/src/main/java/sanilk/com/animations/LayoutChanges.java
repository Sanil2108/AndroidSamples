package sanilk.com.animations;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Scene;
import android.view.ViewGroup;

public class LayoutChanges extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_changes);

        Scene aScene;
        Scene anotherScene;

        ViewGroup sceneRoot = (ViewGroup) findViewById(R.id.scene_root);


        if(Build.VERSION.SDK_INT>=19) {
            aScene = Scene.getSceneForLayout(sceneRoot, R.layout.a_scene, this);
            anotherScene = Scene.getSceneForLayout(sceneRoot, R.layout.another_scene, this);


        }
    }
}
