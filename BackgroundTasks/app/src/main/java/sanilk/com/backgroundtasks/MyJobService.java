package sanilk.com.backgroundtasks;

import android.app.Activity;
import android.app.Service;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

public class MyJobService extends JobService {
    private static final String TAG="MyJobService";

    Handler handler;

    private Context context = this;

    @Override
    public boolean onStartJob(JobParameters params) {
        Log.d(TAG, "Job started");
        startWorkOnNewThread(params);

        handler = new Handler(Looper.getMainLooper()){
            @Override
            public void handleMessage(Message msg) {
                Log.d(TAG, "Handling message");
            }
        };

        return true;
    }

    private void startWorkOnNewThread(final JobParameters jobParameters){
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;i++){
                    try {
                        Thread.sleep(1000);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
                Log.d(TAG, "Job completed");
                handler.sendMessage(new Message());
                jobFinished(jobParameters, false);
            }
        }).start();
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        return false;
    }
}
