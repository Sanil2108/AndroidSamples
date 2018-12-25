package sanilk.com.userinterfaceandnavigation;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import sanilk.com.userinterfaceandnavigation.R;

public class MainActivity extends AppCompatActivity {

    private Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button adapterViewButton = (Button)findViewById(R.id.activity_main_adapter_view_button);
        adapterViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, AdapterView.class);
                startActivity(intent);
            }
        });

        Button contraintLayoutButton = (Button)findViewById(R.id.activity_main_constraint_layout_button);
        contraintLayoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ConstraintLayout.class);
                startActivity(intent);
            }
        });

        Button recyclerViewButton = (Button)findViewById(R.id.activity_main_recycler_view_button);
        recyclerViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, RecyclerView.class);
                startActivity(intent);
            }
        });

        Button gridViewButton = (Button)findViewById(R.id.activity_main_grid_view_button);
        gridViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, GridView.class);
                startActivity(intent);
            }
        });

        Button notificationButton = (Button)findViewById(R.id.activity_main_notifications);
        notificationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Notifications.class);
                startActivity(intent);
            }
        });

        Button statusBarButton = (Button)findViewById(R.id.activity_main_status_bar);
        statusBarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, StatusBarActivity.class);
                startActivity(intent);
            }
        });


        Button viewPagerButton = (Button)findViewById(R.id.activity_main_view_pager);
        viewPagerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ViewPagerActivity.class);
                startActivity(intent);
            }
        });

        Button navBarButton = (Button)findViewById(R.id.activity_main_nav_bar);
        navBarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, NavigationBarActivity.class);
                startActivity(intent);
            }
        });
    }
}
