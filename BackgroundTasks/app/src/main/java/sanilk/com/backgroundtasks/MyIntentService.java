package sanilk.com.backgroundtasks;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.util.Log;

import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MyIntentService extends IntentService {
    public static final String TAG="MyIntentService";

    public MyIntentService(){
        super("Hello world");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d(TAG, "onHandleIntent()");

        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) (new URL("https://www.google.com/")).openConnection();
            httpURLConnection.setDoOutput(false);
            httpURLConnection.setRequestProperty("User-Agent","Mozilla/5.0 ( compatible ) ");
            httpURLConnection.setRequestProperty("Accept","*/*");
            httpURLConnection.setDoInput(true);
            httpURLConnection.connect();

            InputStream in = httpURLConnection.getInputStream();
            int c;
            String s = "Hello";
            while((c=in.read())!=-1){
                s+=(char)c;
            }

            Intent intent1 = new Intent(this, MainActivity.class);
            startActivity(intent1);

            Log.d(TAG, s);
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
