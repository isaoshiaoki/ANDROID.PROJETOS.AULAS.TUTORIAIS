package br.com.softblue.android;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;

public class MainActivity extends Activity {

    private static final int NOTIFICATION_ID = 1;
    private NotificationManager manager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);
        manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
	}

	public void notify(View view) {
		final Notification.Builder builder = new Notification.Builder(this, NotificationUtils.getChannelId(this));
		builder.setContentTitle("Baixando arquivo").setContentText("Aguarde...").setSmallIcon(R.drawable.ic_download);
		builder.setProgress(0, 0, true);

		manager.notify(NOTIFICATION_ID, builder.build());

		new Thread() {
			@Override
			public void run() {
				SystemClock.sleep(5000);
				builder.setProgress(0, 0, false);
				builder.setContentTitle("Arquivo baixado").setContentText("Finalizado");
				manager.notify(NOTIFICATION_ID, builder.build());
			}
		}.start();
	}

    public void notify2(View view) {
		final Notification.Builder builder = new Notification.Builder(this, NotificationUtils.getChannelId(this));
		builder.setContentTitle("Baixando arquivo").setContentText("Aguarde...").setSmallIcon(R.drawable.ic_download);

		manager.notify(NOTIFICATION_ID, builder.build());

		new Thread() {
			@Override
			public void run() {
				for (int i = 1; i <= 100; i += 10) {
					builder.setProgress(100, i, false);
					manager.notify(NOTIFICATION_ID, builder.build());
					SystemClock.sleep(2000);
				}

				builder.setProgress(0, 0, false);
				builder.setContentTitle("Arquivo baixado").setContentText("Finalizado");
				manager.notify(NOTIFICATION_ID, builder.build());
			}
		}.start();
    }
}
