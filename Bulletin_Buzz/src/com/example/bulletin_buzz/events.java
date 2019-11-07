package com.example.bulletin_buzz;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class events extends Activity {
	ListView eventlist;
	Button gotopost4;
	EditText et4,dispose4;
	 public String[] newspost4 = new String[] { "Pratishruti", 
	         "Polaris 2K15",
	         "WAD",
	         "Entrepreneurship development", 
	         "Annakut", 
	         "List View Source Code", 
	         "List View Array Adapter", 
	         "Android Example List View"};
	 public String[] detailpost4 = new String[] { "Annual College Fest", 
	         "Cse dept insto",
	         "Winter WAD",
	         "for first year students only", 
	         "Open invitation", 
	         "List View Source Code", 
	         "List View Array Adapter", 
	         "Android Example List View"};
	 private ArrayList<String> itemArrey4;
	   private ArrayAdapter<String> adaptere;
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.eventpage);
		 et4 = (EditText) findViewById(R.id.editText1);
		 gotopost4=(Button)findViewById(R.id.button2e);
			eventlist = (ListView) findViewById(R.id.listView1e);
			itemArrey4 = new ArrayList<String>();
			for(int j=0;j<newspost4.length;j++)
			  itemArrey4.add(newspost4[j]);
	     adaptere = new ArrayAdapter<String>(events.this,
	               android.R.layout.simple_list_item_1, android.R.id.text1, itemArrey4);
	     eventlist.setAdapter(adaptere);
	     eventlist.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				 int itemPosition1     = position;
				  String  itemValue1    = (String) eventlist.getItemAtPosition(position);
				  Toast.makeText(getApplicationContext(),
		                  "Position :"+itemPosition1+"  ListItem : " +itemValue1 , Toast.LENGTH_LONG)
		                  .show();
		              
		                	 
		                Intent intent = new Intent(events.this, writepost.class);
						startActivity(intent);
						}
			});
	     gotopost4.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View v) {
				additemlist1();
				
			}
	     
	   });
	}
	     protected void additemlist1() {
	   	  if (isInputValid(et4)) {                         ///et=====> EditText et  jaha haum post likh rai pge2.xml
	 	    	itemArrey4.add(0,et4.getText().toString());    /// (index,jaha se post lena hai) 
	 	        et4.setText("");                            ///ek bar post kr diya toh usko blank set kr dena

	 	        adaptere.notifyDataSetChanged();             

	 	    }   

	 	    }

	 	    protected boolean isInputValid(EditText etInput2) {
	 	        // TODO Auto-generatd method stub
	 	        if (etInput2.getText().toString().trim().length()<1) {
	 	           // etInput2.setError("Please Enter Item");
	 	            return false;
	 	        } else {
	 	            return true;
	 	        }

	 	    }

	     
	}
	   


		




