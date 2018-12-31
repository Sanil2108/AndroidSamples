package sanilk.com.backgroundtasks;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.JobIntentService;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Context context = this;

        Button jobSchedulerButton = (Button)findViewById(R.id.activity_main_jobscheduler_button);
        jobSchedulerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ComponentName componentName = new ComponentName(context, MyJobService.class);
                JobInfo jobInfo = new JobInfo.Builder(10, componentName)
                        .setOverrideDeadline(2000)
                        .build();

                JobScheduler jobScheduler = (JobScheduler)getSystemService(JOB_SCHEDULER_SERVICE);
                int result = jobScheduler.schedule(jobInfo);
                if(result == JobScheduler.RESULT_SUCCESS){
                    Log.d("MainActivity", "Success");
                }else{
                    Log.d("MainActivity", "Failed");
                }
            }
        });


        Button intentServiceButton = findViewById(R.id.activity_main_intent_service_button);
        intentServiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MyIntentService.class);
                startService(intent);
            }
        });

    }
}
