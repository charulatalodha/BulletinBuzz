package com.example.bulletin_buzz;

import java.util.ArrayList;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
public class career extends ListActivity {
	String uname;
	public final static String cNAME ="com.example.bulletin_buzz";
	  public void onCreate(Bundle icicle) {
	    super.onCreate(icicle);
	    String[] values = new String[] { "M.B.A","M.S","G.A.T.E ","C.A.T","Other Exams","Job Opportunity"};
	    Intent intent = getIntent();
	     uname = intent.getStringExtra(testing.tNAME);
	    // use your custom layout
	    ArrayAdapter<String> adapter = new ArrayAdapter<String>(career.this,
	    		android.R.layout.simple_list_item_1,android.R.id.text1 , values);
	    setListAdapter(adapter);
	  }

	  @Override
	  protected void onListItemClick(ListView l, View v, int position, long id) {
	    String item = (String) getListAdapter().getItem(position);
	    Toast.makeText(this, item + " selected", Toast.LENGTH_LONG).show();
	    Intent intent = new Intent(career.this, mba.class);
		intent.putExtra(cNAME, uname);
	    startActivity(intent);
	  }

}

///////////////////////////////////////////////////////////////////////////////////////////
/*
public class career extends ListActivity {
	 public String[] cmtlist = new String[] { "Android lollipop:Release", 
     "Latest technology to work on :hadoop"};
	 EditText  writecmt;
	 ArrayList<String> itemArrey2;
	 ArrayAdapter<String> adapter2;
	 String count="5";int cnt=1;
	 ImageButton Blike;TextView likecount;
	 
	protected void onCreate(Bundle savedInstanceState) 
	  {
	    super.onCreate(savedInstanceState);
	    String[] values = new String[] { "Which is the best institute to prepare for G.A.T.E 2014", "Good books for preparations of CAT 2014", "MBA Exams",
		        "Google Internship opportunity", "WebOS", "Ubuntu"};
	    String[] namevalue=new String[]{"Manoj","Abc","Mno","wxy","pqr","Ramesh"};
		    // use your custom layout
		    ArrayAdapter<String> adapter = new ArrayAdapter<String>(career.this,
		        R.layout.carrer_row, R.id.posttext, values);
		    setListAdapter(adapter);
		    
		   /* ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(career.this,
			        R.layout.carrer_row, R.id.name, namevalue);
			    setListAdapter(adapter2);  
	     */
		/*    Blike = (ImageButton) findViewById(R.id.blike);
		    likecount = (TextView) findViewById(R.id.likecount);
			Blike.setOnClickListener(new View.OnClickListener() {

	          public void onClick(View v) { 
	        	  likecount = (TextView) findViewById(R.id.likecount);
	        	count=count.valueOf(cnt++);
	      		likecount.setText(count );

	            }
	            
	        });
		    
	  }
	  }
	*/
/*     Button bcomment = (Button) findViewById(R.id.bcomment);
		   writecmt=(EditText)findViewById(R.id.writecmt);
		 ListView clist = (ListView) findViewById(R.id.cmtlistView);
		   itemArrey2 = new ArrayList<String>();
			for(int j=0;j<cmtlist.length;j++)
			  itemArrey2.add(cmtlist[j]);
			adapter2 = new ArrayAdapter<String>(career.this,
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
*/
	  

