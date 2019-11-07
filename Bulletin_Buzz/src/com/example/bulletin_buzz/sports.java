package com.example.bulletin_buzz;
import java.util.ArrayList;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
//import android.widget.TextView;
import android.widget.Toast;

public class sports extends Activity  {
/* step1:on creatre method  setContentView(R.layout.xml layout file);
	     2:get buuton id, sri ids..
	     3. set on click listener
	     4. arry adapter set ///on create 
	    
*/
	ListView sportlist;
	Button gotopost1;
	EditText et1,dispose1;
	  public String[] newspost1 = new String[] { "Branch Cup:football matches", 
              "Annual Athelatic Meet",
              "Badminton trials",
              "Chess trial", 
              "Physical fitness", 
              "List View Source Code", 
              "List View Array Adapter", 
              "Android Example List View"};
	  public String[] detailpost1 = new String[] { "Semi final match", 
              "to be held at police ground",
              "at marriage hall",
              "bring your board ", 
              "at gym khana", 
              "List View Source Code", 
              "List View Array Adapter", 
              "Android Example List View"};
	  private ArrayList<String> itemArrey1;
	    private ArrayAdapter<String> adapters;
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sportspage);
		 et1 = (EditText) findViewById(R.id.editTextvd);
		 gotopost1=(Button) findViewById(R.id.b2);
			sportlist = (ListView) findViewById(R.id.listView1s);
			itemArrey1 = new ArrayList<String>();
			for(int j=0;j<newspost1.length;j++)
			  itemArrey1.add(newspost1[j]);
	      adapters = new ArrayAdapter<String>(sports.this,
	                android.R.layout.simple_list_item_1, android.R.id.text1, itemArrey1);
	      sportlist.setAdapter(adapters);
	      sportlist.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				 int itemPosition1     = position;
				  String  itemValue1    = (String) sportlist.getItemAtPosition(position);
				  Toast.makeText(getApplicationContext(),
		                  "Position :"+itemPosition1+"  ListItem : " +itemValue1 , Toast.LENGTH_LONG)
		                  .show();
		              
		                	 
		                Intent intent = new Intent(sports.this, writepost.class);
						startActivity(intent);
						}
			});
	      gotopost1.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View v) {
				additemlist1();
				
			}
	      
	    });
	}
	      protected void additemlist1() {
	    	  if (isInputValid(et1)) {                         ///et=====> EditText et  jaha haum post likh rai pge2.xml
	  	    	itemArrey1.add(0,et1.getText().toString());    /// (index,jaha se post lena hai) 
	  	        et1.setText("");                            ///ek bar post kr diya toh usko blank set kr dena

	  	        adapters.notifyDataSetChanged();             

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
	    



