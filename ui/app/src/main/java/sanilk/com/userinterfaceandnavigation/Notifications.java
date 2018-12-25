package sanilk.com.userinterfaceandnavigation;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Notifications extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);

        final Context context = this;

        createNotificationChannel();

        Intent intent = new Intent(this, Notifications.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        final PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        Intent homeIntent = new Intent(this, MainActivity.class);
        final PendingIntent homePendingIntent = PendingIntent.getActivity(this, 0, homeIntent, 0);

        Button simple = (Button)findViewById(R.id.activity_notifications_simple);
        simple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "Default")
                        .setSmallIcon(R.drawable.ic_launcher_foreground)
                        .setContentTitle("Content Tiel")
                        .setContentText("Content text")
                        .setContentIntent(pendingIntent)
                        .addAction(new NotificationCompat.Action(R.drawable.ic_launcher_foreground, "Go home", homePendingIntent))
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT);

                NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(context);
                notificationManagerCompat.notify(0, builder.build());


            }
        });
    }


    private void createNotificationChannel(){
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel notificationChannel = new NotificationChannel("Default", "Default",
                    NotificationManager.IMPORTANCE_DEFAULT);
            notificationChannel.setDescription("The default channel");
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }
}
