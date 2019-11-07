package com.example.bulletin_buzz;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

	public class MainActivity extends ActionBarActivity {
		 EditText  uname;
		 EditText  pwd;
		 TextView atmpt;
		 Button blogin;
		int counter = 3;
		String username ,name,passwd,id;
		String password;
		public final static String EXTRA_MESSAGE ="com.example.bulletin_buzz";
		public final static String ID ="com.example.bulletin_buzz";
		public final static String NAME ="com.example.bulletin_buzz";
		String tag="log" ;
		static final int ok = 1;
		// Progress Dialog
		private ProgressDialog pDialog;
		 
		// JSON parser class
		JSONParser jsonParser = new JSONParser();
		private static  String LOGIN_URL ="http://10.0.2.2/bbuz/login.php";                 ////"http://10.0.2.2/bbuz/login.php";
		private static final String TAG_SUCCESS = "success";
		private static final String TAG_MESSAGE = "message";
		JSONArray login_array= null;

	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_main);
	        
	        uname = (EditText)findViewById(R.id.editText1);
	         pwd = (EditText)findViewById(R.id.editText2 );
	         blogin=(Button)findViewById(R.id.button1 );
	         atmpt=(TextView)findViewById(R.id.textView5);

	         Log.d(tag, "Bullentin Buzz started");
	 
	 		blogin.setOnClickListener(new OnClickListener() {
	 			
	 			@Override
	 			public void onClick(View v) {
	 				Log.d(tag, "on button click");
	 				
	 				username = uname.getText().toString().trim();
	 				password = pwd.getText().toString().trim();
	 			//	Intent intent = new Intent(MainActivity.this, mba.class);
	 				//intent.putExtra(EXTRA_MESSAGE, username);
	 			
	 				
	 				Log.d(tag, "after selecting names " + username +""+password +"");
	 			    new AttemptLogin().execute();
//	 			   Intent intent = new Intent(MainActivity.this, testing.class);
	 //			   startActivity(intent);

	/*
	 			    if(uname.getText().toString().equals("admin") && 
	 			              pwd.getText().toString().equals("admin"))
	 				{
	 			      Toast.makeText(getApplicationContext(), "Redirecting...", 
	 			      Toast.LENGTH_SHORT).show();
	 		          Intent intent = new Intent(MainActivity.this, testing.class);
	 					startActivity(intent);
	 			      }	
	 			   else{
	 			      Toast.makeText(getApplicationContext(), "Wrong Credentials",
	 			      Toast.LENGTH_SHORT).show();
	 			      //attempts.setBackgroundColor(Color.RED);	
	 			      counter--;
	 			      atmpt.setText(Integer.toString(counter));
	 			      if(counter==0){
	 			         blogin.setEnabled(false);
	 			      }

	 			   }*/
	}
	 		}
	 			);
	     
	         
	    }
	    



	class AttemptLogin extends AsyncTask<String, String, String> {
	 
	//boolean failure = false;
	 
	@Override
	protected void onPreExecute() {             /////////
	       super.onPreExecute();
	pDialog = new ProgressDialog(MainActivity.this);
	pDialog.setMessage("Attempting login...");
	pDialog.setIndeterminate(false);
	pDialog.setCancelable(true);
	pDialog.show();
	}
	 
	@Override
	protected String doInBackground(String... args) {
	// TODO Auto-generated method stub
	// Check for success tag
		pDialog.setMessage("background login...");
	 
	List<NameValuePair> params = new ArrayList<NameValuePair>(); 
	    //pDialog.setMessage("after list array ...");
	params.add(new BasicNameValuePair("uname", username));
	params.add(new BasicNameValuePair("pwd", password));
	 
	Log.d("request!", "starting");
	 
	JSONObject json = jsonParser.makeHttpRequest(LOGIN_URL, "GET", params);
	 
	// check your log for json response
	Log.d("Login attempt", json.toString());
	 
	// json success tag

	try {
		// Checking for SUCCESS TAG
		int success = json.getInt(TAG_SUCCESS);
	   
		if (success == 1) {
			// products found
			// Getting Array of Products
			login_array = json.getJSONArray("login_array");
		
			Log.d(tag,"this is success log ");
			
			// looping through All Products
			for (int i = 0; i < login_array.length(); i++) {
				JSONObject c = login_array.getJSONObject(i);

				// Storing each json item in variable
				 name = c.getString("username");
				 passwd = c.getString("password");
				 id = c.getString("id");
	
				// Intent intent = new Intent(MainActivity.this,mba.class);
					//intent.putExtra("ID",id);
					//intent.putExtra("NAME", name);
			     //		startActivity(intent); 
				
			}
		} else {
			// no products found
			// Launch Add New product Activity
		}
	} catch (JSONException e) {
		e.printStackTrace();
	}

	return null;
	}

	protected void onPostExecute(String file_url) {
	// dismiss the dialog after getting all products
	pDialog.dismiss();
	// updating UI from Background Thread
	if(name!= null){
	Intent intent = new Intent(MainActivity.this, testing.class);
	intent.putExtra(NAME, name);
		startActivity(intent);
	}
	else{
		//Intent intent = new Intent(MainActivity.this,MainActivity.class);
		//startActivity(intent);
		Toast.makeText(getApplicationContext(), "Wrong Credentials",
			      Toast.LENGTH_SHORT).show();
		uname.setText(""); pwd.setText("");
		//attempts.setBackgroundColor(Color.RED);	
			      counter--;
			      atmpt.setText(Integer.toString(counter));
			      if(counter==0)
			         blogin.setEnabled(false);
	      	}

       	}
	

	}
	}


