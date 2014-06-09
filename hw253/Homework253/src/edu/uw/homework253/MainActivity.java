package edu.uw.homework253;

import edu.uw.homework253.MainActivity;
import edu.uw.homework253.MyService;
import edu.uw.homework253.R;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.os.Build;

public class MainActivity extends Activity {

	Button startButton;
	NotificationManager notificationManager;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		startButton= (Button) findViewById(R.id.button1);
	}

	
	public void buttonAction(View view){
		
	String buttonTxt= startButton.getText().toString();
		
		if(buttonTxt.equals("Start"))
		{
			startButton.setText("Stop");
			startNewService(view);
			  
			//launch notification
			NotificationManager notificationManager = (NotificationManager) getSystemService(getBaseContext().NOTIFICATION_SERVICE);
			Notification mNotification = new Notification(R.drawable.ic_launcher, "Sound is playing...", System.currentTimeMillis() );
			String MyNotificationTitle = "Sound Playing!";
            String MyNotificationText  = "The sound will keep playing every 5 seconds...";
            
            Intent MyIntent = new Intent(this, MainActivity.class);
            MyIntent.setAction(Intent.ACTION_MAIN);
            MyIntent.addCategory(Intent.CATEGORY_LAUNCHER);
                          PendingIntent StartIntent = PendingIntent.getActivity(getApplicationContext(),0,MyIntent, PendingIntent.FLAG_CANCEL_CURRENT);
                    
                          mNotification.setLatestEventInfo(getApplicationContext(), MyNotificationTitle, MyNotificationText, StartIntent);
            
                          int NOTIFICATION_ID = 1;
            
                          notificationManager.notify(NOTIFICATION_ID , mNotification); 


		}
		else
		{
			// Stop the  service and change the button text
			startButton.setText("Start");
			stopNewService(view);
		}
	}
	
	
	// Start the  service
	public void startNewService(View view) {

		startService(new Intent(this, MyService.class));
	}

	
	public void stopNewService(View view) {
		
		stopService(new Intent(this, MyService.class));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
