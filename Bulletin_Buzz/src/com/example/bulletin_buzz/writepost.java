package com.example.bulletin_buzz;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class writepost extends Activity {
	Button bcomment,exit;
	TextView likecount;
	TextView posttext,textView;
	EditText writecmt;
	ImageButton Blike;
	ListView clist;
	String count="5";int cnt=1;
	  private ArrayList<String> itemArrey2;
	    private ArrayAdapter<String> adapter2;
	    public String[] cmtlist = new String[] { "Android lollipop:Release", 
	               "Latest technology to work on :hadoop"};

       
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		   
	    // Get the message from the intent
	    Intent intent = getIntent();
	    String message = intent.getStringExtra(tech.EXTRA_MESSAGE);
	    setContentView(R.layout.writepost);
	    textView=(TextView)findViewById(R.id.posttext);
	          textView.setText(message);
	 
	    Blike = (ImageButton) findViewById(R.id.blike);
	    bcomment = (Button) findViewById(R.id.bcomment);
		likecount = (TextView) findViewById(R.id.likecount);
		Blike.setOnClickListener(new View.OnClickListener() {

          public void onClick(View v) { 
        	  likecount = (TextView) findViewById(R.id.likecount);
        	count=count.valueOf(cnt++);
      		likecount.setText(count );

            }
            
        });
//////////////////////// EXIT ////////////////////////
	 
	/*	 exit = (Button) findViewById(R.id.exit);
		 
		 exit.setOnClickListener(new View.OnClickListener() {

	          public void onClick(View v) { 
	         
	            }
	            
	        });  */
		///////////////////////////   COMMENT  ////////////////////////////////
		 writecmt=(EditText)findViewById(R.id.writecmt);
		clist = (ListView) findViewById(R.id.cmtlistView);
		itemArrey2 = new ArrayList<String>();
		for(int j=0;j<cmtlist.length;j++)
		  itemArrey2.add(cmtlist[j]);
		 adapter2 = new ArrayAdapter<String>(writepost.this,
	                android.R.layout.simple_list_item_1, android.R.id.text1, itemArrey2);
		  clist.setAdapter(adapter2);   
		  bcomment.setOnClickListener(new View.OnClickListener() {

              public void onClick(View v) {  //////to add items to the list

                  addItemList();            //func called
                }
              
          });
          
  	}

  	 protected void addItemList() {
  	        // TODO Auto-generated method stub

  	        // TODO Auto-generated method stub
  	    if (isInputValid(writecmt)) {                         
  	    	itemArrey2.add(0,writecmt.getText().toString());    
  	        writecmt.setText("");                            
  	        adapter2.notifyDataSetChanged();        }   

  	    }

  	    protected boolean isInputValid(EditText etInput2) {
  	    
  	        if (etInput2.getText().toString().trim().length()<1) {
  	           etInput2.setError("Please Enter Item");
  	            return false;
  	        } else {
  	            return true;
  	        }

  	    }


   

	}
