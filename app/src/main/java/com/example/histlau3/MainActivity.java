package com.example.histlau3;

//import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends Activity {

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log("Запуск");

        Timer timer = new Timer(); // https://stackoverflow.com/questions/4597690/how-to-set-timer-in-android
        TimerTask ttask = new TimerTask() { // https://stackoverflow.com/questions/39118568/how-do-i-set-a-timer-for-a-textview-this-keeps-crashing-my-app
            @Override
            public void run() {
                //Log("Таймер");
                try{
                    //Log("Таймер");
                //String currentTime = new SimpleDateFormat("HH:mm:ss.SSS", Locale.getDefault()).format(new Date());
                //myText.setText("currentTime");
                }catch(Exception e){
                    Log(e.toString());
                }
            }
        };
        timer.scheduleAtFixedRate(ttask,1000,1000);
    }

    public void exitApp(View view) {   super.finishAffinity();    }

    public void Log(String s) {
        TextView tv = (TextView)findViewById(R.id.textView);
        String currentTime = new SimpleDateFormat("HH:mm:ss.SSS", Locale.getDefault()).format(new Date());
        tv.append(currentTime + " " + s + "\n");
    }

    public void showHistory(String s) {
        Log("Нажал");
        try {
            Intent intent = new Intent();
            intent.setClassName("com.android.settings", s);
            startActivity(intent);
        } catch(Exception e){
            Log(e.toString());
        }
    }

    public void history12(View view) { showHistory("com.android.settings.notification.history.NotificationHistoryActivity");  }
    public void history9(View view) { showHistory("com.android.settings.Settings$NotificationStationActivity");  }
}