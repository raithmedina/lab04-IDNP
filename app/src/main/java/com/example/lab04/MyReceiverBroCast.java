package com.example.lab04;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

public class MyReceiverBroCast extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        boolean mensa = (action.equals("com.example.lab04"));
        if (mensa){
            Log.d("Salida", "LO RECIBI");
        } else {
            Log.d("Salida", "No lo recibi");
        }
    }
}