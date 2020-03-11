package com.example.esther;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.view.Gravity;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        Toast toast=Toast.makeText(context,"Your alarm is about to fire",Toast.LENGTH_LONG);
        //sets the position of the toast
        toast.setGravity(Gravity.CENTER,0,0);
        toast.show();
        //calling the vibdator to shake the phone
        Vibrator vibrator=(Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(3000);
    }
}
