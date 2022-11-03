package com.example.lab04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {

    public static String mensaje = "";
    private MyReceiverBroCast br;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.buttonSendLocalBroCast);
    }

    @Override
    protected void onResume() {
        super.onResume();
        br = new MyReceiverBroCast();
        registerReceiver(br,new IntentFilter("com.example.lab04"));
        envia ();
    }

    private void envia (){
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText msj = findViewById(R.id.editTextMen);
                mensaje = msj.getText().toString();
                Intent i = new Intent();
                i.setAction("com.example.lab04");
                sendBroadcast(i);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(br);
    }
}
