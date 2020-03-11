package com.example.esther;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    BroadcastReceiver r=new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {
            int y = intent.getIntExtra("level", 0);
            ProgressBar bar = (ProgressBar) findViewById(R.id.progressBar);
            bar.setProgress(y);
            TextView textView = (TextView) findViewById(R.id.textView2);
            textView.setText("battery level displayed" + Integer.toString(y) + "%");

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registerReceiver(r,new IntentFilter(Intent.ACTION_BATTERY_CHANGED));

        Button mus=(Button)findViewById(R.id.button);
        mus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,music.class);
                startActivity(intent);
            }
        });

    }
    public void sendMessage(View view) {
        EditText message = (EditText) findViewById(R.id.message);
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        intent.putExtra("MESSAGE", message.getText().toString());
        startActivity(intent);
        message.setText("");
        Toast.makeText(this, "Sending message " + message.getText().toString(),
                Toast.LENGTH_SHORT).show();
    }

        public boolean onCreateOptionsMenu(Menu menu){
            MenuInflater inflater=getMenuInflater();
            inflater.inflate(R.menu.maria,menu);

           return true;
        }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.evelyn:
                // startActivity(new Intent(this,menusal.class));
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:0781129716"));
                // if (ActivityCompat.checkSelfPermission(MainActivity.this,
                //  Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                startActivity(intent);
                return true;
            //}




            case R.id.elijah:
                // startActivity(new Intent(this,menu2.class));
                Intent intent2 = new Intent(Intent.ACTION_SEND);
                intent2.setData(Uri.parse("mailto:"));
                String to[] = {"elinahnabasitu@gmail.com", "emary3583@gmail.com", "birungitricia1@gmail.com"};
                intent2.putExtra(Intent.EXTRA_EMAIL, to);
                intent2.putExtra(Intent.EXTRA_SUBJECT, "this is cool read this");
                intent2.putExtra(Intent.EXTRA_TEXT, "this group is cool");
                intent2.setType("message/rfc822");
                startActivity(intent2);
                return true;


            default:

                return super.onContextItemSelected(item);
        }
    }

    public void alarm(View view) {
        EditText e = (EditText) findViewById(R.id.editText);
        //int t = Integer.parseInt (String.valueOf(e));
        int b =Integer.parseInt(e.getText().toString());

        //Create the intent and call your receiver explicit intent
        Intent intent= new Intent(getApplicationContext(),MyReceiver.class);
        PendingIntent pendingIntent;
        //creating the pending intent
        //PendingIntent =PendingIntent.getBroadcast(this.getApplicationContext(),0,intent,0);
        //calling the alarm manager class to use the alarm also accessing the system service method to access services provided by
        // the android system
        pendingIntent=PendingIntent.getBroadcast(this.getApplicationContext(),0,intent,0);
        AlarmManager alarmManager=(AlarmManager)getSystemService(ALARM_SERVICE);
        //setting the alarm time
        alarmManager.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis() + (b* 1000),pendingIntent);
        //make toast using a class Toast
        Toast.makeText(this,"Alarm set in"+ b +"seconds",Toast.LENGTH_LONG).show();
    }
}

