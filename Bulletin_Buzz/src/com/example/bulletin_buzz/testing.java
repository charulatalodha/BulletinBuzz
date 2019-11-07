package com.example.bulletin_buzz;

//package com.bbuzz1.example;

//import com.bbuzz1.example.MainActivity.AttemptLogin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class testing extends Activity {
	Button Technology,Sports,Events,Dept,Books,Faculty,Career,logout;
	String uname;
	public final static String tNAME ="com.example.bulletin_buzz";
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.t);
		Intent intent = getIntent();
		     uname = intent.getStringExtra(MainActivity.NAME);
		Sports = (Button) findViewById(R.id.button11);
	    Technology = (Button) findViewById(R.id.button22);
	    Dept = (Button) findViewById(R.id.button33);
		Books= (Button) findViewById(R.id.button44);
		Events = (Button) findViewById(R.id.button55);
		Faculty = (Button) findViewById(R.id.button66);
		Career = (Button) findViewById(R.id.button77);
		logout = (Button) findViewById(R.id.logoutbt);
		/////////////////////////////////////////////////////////////////
         logout.setOnClickListener(new OnClickListener() {
 			
 			@Override
 			public void onClick(View v) {
 				Intent intent = new Intent(testing.this, MainActivity.class);   //done..
				startActivity(intent);
			    	
        }
 		}
 		);
		//////////////////////////////////////////////////////////////
		Technology.setOnClickListener(new OnClickListener() {
 			
 			@Override
 			public void onClick(View v) {
 				Intent intent = new Intent(testing.this, tech.class);   //done..
				startActivity(intent);
			    	
        }
 		}
 		);
    ////////////////////////////////////////////////////////////////////
		Sports.setOnClickListener(new OnClickListener() {
 			
 			@Override
 			public void onClick(View v) {
 				Intent intent = new Intent(testing.this, sports.class);
				startActivity(intent);
			    
                                        }
 		}
 		);
      ///////////////////////////////////////////////////////////////////
		Events.setOnClickListener(new OnClickListener() {
 			
 			@Override
 			public void onClick(View v) {
 				Intent intent = new Intent(testing.this, events.class);
				startActivity(intent);
			    
                                        }
 		}
 		);
       ///////////////////////////////////////////////////////////////////
		Dept.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Intent intent = new Intent(testing.this, dept.class);
			startActivity(intent);
		    
                                }
	}
	);
		//////////////////////////////////////////////////////////////////
		Books.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Intent intent = new Intent(testing.this, books.class);
			intent.putExtra(tNAME, uname);
			startActivity(intent);
                    }
	}
	);
		////////////////////////////////////////////////////////////////
		Faculty.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(testing.this, faculty.class);
				startActivity(intent);
	                    }
		}
		);
		/////////////////////////////////////////////////////////////////
Career.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(testing.this, career.class);
				intent.putExtra(tNAME, uname);
				startActivity(intent);
	                    }
		}
		);
 //////////////////////   END OF ONCLICK LISTENER ////////////////////////	
		
	}

}
