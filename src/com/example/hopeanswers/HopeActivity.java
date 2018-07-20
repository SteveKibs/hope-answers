package com.example.hopeanswers;
 
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import winterwell.jtwitter.Twitter;
public class HopeActivity extends ActionBarActivity {
EditText editText;
Button buttonUpdate;
TextView titleStatus;
Twitter twitter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		//Parse.initialize(context, applicationId, clientKey)
		super.onCreate(savedInstanceState);
		
		//inflate from XML
		setContentView(R.layout.activity_hope);
		editText=(EditText)findViewById(R.id.editText);
		buttonUpdate=(Button)findViewById(R.id.buttonUpdate);
		buttonUpdate.setOnClickListener((OnClickListener) this);
		
		twitter=new Twitter("student", "password");
		//twitter.SetApIRootUrl("http://yamba.marakana.com/api");
		twitter.setAPIRootUrl("http://yamba.marakana.com/api");
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.hope, menu);
		return true;
	}
	private static final String TAG="HopeActivity";
	//called when button is clicked
	public void onClick(View v){
		twitter.setStatus(editText.getText().toString());
		Log.d(TAG, "onClick");
		
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
