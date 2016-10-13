package com.salim3dd.action_notification;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;

import java.util.Random;


public class AlertReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        String[] All_Duaa = context.getResources().getStringArray(R.array.All_Duaa);
        Random Rnd = new Random();
        int NUM = Rnd.nextInt(All_Duaa.length);
        String Duaa_TXT = All_Duaa[NUM];

        Intent intent_Page2 = new Intent(context, Page2.class);
        intent_Page2.putExtra("Duaa_TXT2",Duaa_TXT);
        PendingIntent pendOpne = PendingIntent.getActivity(context, 222, intent_Page2, PendingIntent.FLAG_UPDATE_CURRENT);

        Intent intent_Page3 = new Intent(context, Page3.class);
        intent_Page3.putExtra("Duaa_TXT3",Duaa_TXT);
        PendingIntent pend_Page3 = PendingIntent.getActivity(context, 333, intent_Page3, PendingIntent.FLAG_UPDATE_CURRENT);

        Intent intent_mainActivity = new Intent(context, MainActivity.class);
        PendingIntent notification = PendingIntent.getActivity(context, 100, intent_mainActivity, 0);

        Bitmap bitmap_icon = BitmapFactory.decodeResource(context.getResources(), R.drawable.logo_144);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
                .setSmallIcon(R.drawable.ic_notifications_active_black_24dp)
                .setLargeIcon(bitmap_icon)
                .setContentTitle("أدعية قرآنية")
                .setContentText(Duaa_TXT)
                .addAction(R.drawable.ic_reply_black_24dp, "فتح الدعاء ", pendOpne)
                .addAction(R.drawable.ic_share_black_24dp, " مشاركة ", pend_Page3);



        builder.setContentIntent(notification);
        builder.setDefaults(NotificationCompat.DEFAULT_SOUND);
        builder.setAutoCancel(true);

        NotificationManager mm = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        mm.cancel(1);
        mm.notify(1, builder.build());

    }


}
