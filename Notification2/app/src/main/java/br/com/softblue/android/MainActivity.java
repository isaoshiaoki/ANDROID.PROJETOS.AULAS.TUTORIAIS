package br.com.softblue.android;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    public static final int NOTIFICATION_ID = 50;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void notify(View view) {
        Notification.Builder builder = new Notification.Builder(this, NotificationUtils.getChannelId(this));
        builder.setSmallIcon(android.R.drawable.sym_action_chat);

        Notification.BigTextStyle style = new Notification.BigTextStyle()
                .setBigContentTitle("Título da Notificação")
                .bigText("Texto da notificação");
        builder.setStyle(style);

        Intent intent1 = new Intent(this, NotificationReceiver.class);
        intent1.setAction(NotificationReceiver.ACTION_BUTTON_1);
        PendingIntent pendingIntent1 = PendingIntent.getBroadcast(this, 0, intent1, 0);
        Intent intent2 = new Intent(this, NotificationReceiver.class);
        intent2.setAction(NotificationReceiver.ACTION_BUTTON_2);
        PendingIntent pendingIntent2 = PendingIntent.getBroadcast(this, 0, intent2, 0);

        Icon icon = Icon.createWithResource(this, android.R.drawable.ic_menu_view);
        Notification.Action action1 = new Notification.Action.Builder(icon, "Botão 1", pendingIntent1).build();
        Notification.Action action2 = new Notification.Action.Builder(icon, "Botão 2", pendingIntent2).build();

        builder.addAction(action1);
        builder.addAction(action2);

        Notification n = builder.build();
        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        if (nm != null) {
            nm.notify(NOTIFICATION_ID, n);
        }
    }
}
