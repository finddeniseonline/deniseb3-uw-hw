package edu.uw.homework253;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends Service {
	public MyService() {
	}

	 private static Timer timer = new Timer(); 
	 MediaPlayer mediaPlayer;
	@Override
	public IBinder onBind(Intent intent) {
		// TODO: Return the communication channel to the service.
		throw new UnsupportedOperationException("Not yet implemented");
	}
	
	
	@Override
    public void onCreate() {
       // Toast.makeText(this, "The new Service was Created", Toast.LENGTH_LONG).show();
        mediaPlayer = MediaPlayer.create(getBaseContext(), R.raw.ding);
       
    }
 
    @Override
    public void onStart(Intent intent, int startId) {
    	// For time consuming an long tasks you can launch a new thread here...
        //Toast.makeText(this, " Service Started", Toast.LENGTH_LONG).show();
       
    	timer.scheduleAtFixedRate(new mainTask(), 0, 5000);
    }
 
    public class mainTask extends TimerTask{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			mediaPlayer.start();
			
		}}
    @Override
    public void onDestroy() {
       //Toast.makeText(this, "Service Destroyed", Toast.LENGTH_LONG).show();
        mediaPlayer.stop();
        
    }
}
