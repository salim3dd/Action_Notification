package com.salim3dd.action_notification;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class Page3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page3);

        Intent intent = getIntent();

        if (intent.hasExtra("Duaa_TXT3")) {

            Intent share = new Intent(Intent.ACTION_SEND);
            share.setType("text/plain");
            share.putExtra(Intent.EXTRA_TEXT, intent.getExtras().getString("Duaa_TXT3"));
            if (share.resolveActivity(getPackageManager()) != null) {
                startActivity(Intent.createChooser(share, "مشاركة الدعاء "));
            }
        }

        NotificationManager mm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mm.cancel(1);

        finish();

    }
}
