package br.com.softblue.android;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

	private static final int NOTIFICATION_ID = 50;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_main);
	}
	
	public void notify(View view) {
		Notification.Builder builder = new Notification.Builder(this, NotificationUtils.getChannelId(this));
		builder.setContentTitle("Título da Notificação");
		builder.setContentText("Este é o texto da notificação");
		builder.setSmallIcon(android.R.drawable.sym_action_chat);

		Intent intent = new Intent(this, MessageActivity.class);
		PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
		builder.setContentIntent(pendingIntent);
		builder.setAutoCancel(true);

		Notification notification = builder.build();

		NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

		if (nm != null) {
			nm.notify(NOTIFICATION_ID, notification);
		}
	}
}
