package br.com.softblue.android;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class NotificationReceiver extends BroadcastReceiver {
    public static final String ACTION_BUTTON_1 = "br.com.softblue.android.action.ACTION_BUTTON_1";
    public static final String ACTION_BUTTON_2 = "br.com.softblue.android.action.ACTION_BUTTON_2";

    @Override
    public void onReceive(Context context, Intent intent) {

        String action = intent.getAction();
        String msg;

        switch (action) {
            case ACTION_BUTTON_1:
                msg = "Botão 1 clicado!";
                break;
            case ACTION_BUTTON_2:
                msg = "Botão 2 clicado!";
                break;
            default:
                msg = "Ação desconhecida";
                break;
        }

        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();

        NotificationManager nm = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        nm.cancel(MainActivity.NOTIFICATION_ID);
    }
}
