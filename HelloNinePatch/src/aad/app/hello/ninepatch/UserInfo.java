package aad.app.hello.ninepatch;

import android.app.Activity;
import android.app.Fragment;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class UserInfo extends Activity {

	Button button;
	TextView userName;
	TextView password;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		SharedPreferences sharedPreferences = PreferenceManager
    			.getDefaultSharedPreferences(this);
		//get email and password
		userName = (TextView)findViewById(R.id.showEmail);
		password = (TextView)findViewById(R.id.showPassword);
		String storedUsername=sharedPreferences.getString("email","");  

		//text to equal the variables
		 String storedPassword= sharedPreferences.getString("password","");
		//String sharedPreference = SharedPreferences.getString("")
		userName.setText("Your email is " + storedUsername);
		password.setText("Your password is " + storedPassword);
		
		/**
		 lblName.setText(Html.fromHtml("Name: <b>" + name + "</b>"));
	        lblEmail.setText(Html.fromHtml("Email: <b>" + email + "</b>")
	        */
		

	}



}
