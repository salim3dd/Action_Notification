package com.salim3dd.action_notification;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Page2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);

        TextView textView1 = (TextView) findViewById(R.id.textView1);

        Intent intent = getIntent();
        if (intent.hasExtra("Duaa_TXT2")) {
            textView1.setText(intent.getExtras().getString("Duaa_TXT2"));
        }

        NotificationManager mm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mm.cancel(1);

    }
}
