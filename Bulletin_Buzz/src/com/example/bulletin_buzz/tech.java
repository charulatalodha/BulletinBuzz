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

public class tech extends Activity {
	ListView techlist;
	Button gotopost;
	EditText et,dispose;
	
	public final static String EXTRA_MESSAGE ="com.example.bulletin_buzz";
	  public String[] newspost = new String[] { "Android lollipop:Release", 
               "Latest technology to work on :hadoop",
               "New release IOS 8",
               "Windows 10 preview", 
               "google glasses", 
               "List View Source Code", 
               "List View Array Adapter", 
               "Android Example List View"};
	  public String[] detailpost = new String[] { " Better multitasking,better battery", 
              "Latest technology to work on :hadoop New Cross-Platform by Apache softwarehfjfhffhfhhhmffhfhfjhfhfhfghfgfxexygibinnimnubczzz",
              "Recently reale of os has many bugs...",
              "Windows 10 preview", 
              "google glasses", 
              "List View Source Code", 
              "List View Array Adapter", 
              "Android Example List View"};
	  public String[] names = new String[] { " Narendra Modi" +
	  		"Antra patni" +
	  		"Charulata lodha" +
	  		"Darshan Daga" +
	  		"Veeral Dhabalia" +
	  		"Sanjana Batra"+
	  		"pratik" +
	  		"raj" +
	  		"neha"}; 
             
	  private ArrayList<String> itemArrey;
	    private ArrayAdapter<String> adapter1;
         
            
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.page2);
		
		
		 et = (EditText) findViewById(R.id.updatepost);
		gotopost=(Button)findViewById(R.id.PostButton2);
		techlist = (ListView) findViewById(R.id.ListView1);
		
              ///////////////////////////////
		itemArrey = new ArrayList<String>();
		for(int j=0;j<newspost.length;j++)
		  itemArrey.add(newspost[j]);
			
		
      adapter1 = new ArrayAdapter<String>(tech.this,
                android.R.layout.simple_list_item_1, android.R.id.text1, itemArrey);
        
	      
      
        techlist.setAdapter(adapter1);          // Assign adapter to ListView 
                                               // ListView Item Click Listener
        techlist.setOnItemClickListener(new OnItemClickListener() {

              @Override
              public void onItemClick(AdapterView<?> parent, View view,
                 int position, long id) {
                
               // ListView Clicked item index
               int itemPosition     = position;
               
               // ListView Clicked item value
               String  itemValue    = (String) techlist.getItemAtPosition(position);
                  
                // Show Alert 
                Toast.makeText(getApplicationContext(),
                  "Position :"+itemPosition+"  ListItem : " +itemValue , Toast.LENGTH_LONG)
                  .show();
                
                Intent intent = new Intent(tech.this, writepost.class);
             //   EditText editText = (EditText) findViewById(R.id.edit_message);
            //	String message = editText.getText().toString();
           // 	intent.putExtra(EXTRA_MESSAGE, message);
             	intent.putExtra(EXTRA_MESSAGE, detailpost[itemPosition]);
                startActivity(intent);
				  
                 }

         }); 
        
      
        gotopost.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {  //////to add items to the list

                addItemList();            //func called
              }
            
        });
        
	}

	 protected void addItemList() {
	        // TODO Auto-generated method stub

	        // TODO Auto-generated method stub
	    if (isInputValid(et)) {                         
	    	itemArrey.add(0,et.getText().toString());    
	        et.setText("");                            
	        adapter1.notifyDataSetChanged();        }   

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
	













        ///////////////////////////////////////////////////////////////////
         //////////////////// example /////////////////////
   /*     final StableArrayAdapter adapter2 = new StableArrayAdapter(this,
		        android.R.layout.simple_list_item_activated_1 , newspost);
		   
        techlist.setAdapter(adapter2);

        techlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {

		      @Override
		      public void onItemClick(AdapterView<?> parent, final View view,
		          int position, long id) {
		        final String item = (String) parent.getItemAtPosition(position);
		        view.animate().setDuration(2000).alpha(0)
		            .withEndAction(new Runnable() {
		              @Override
		              public void run() {
		            	  techlist.remove(item);
		                adapter2.notifyDataSetChanged();
		                view.setAlpha(1);
		              }
		            });
		      }

		    });   */
        
        
        
	

/*	  private class StableArrayAdapter extends ArrayAdapter<String> {

	    HashMap<String, Integer> mIdMap = new HashMap<String, Integer>();

	    public StableArrayAdapter(Context context, int textViewResourceId,
	        List<String> objects) {
	      super(context, textViewResourceId, objects);
	      for (int i = 0; i < objects.size(); ++i) {
	        mIdMap.put(objects.get(i), i);
	      }
	    }

	    @Override
	    public long getItemId(int position) {
	      String item = getItem(position);
	      return mIdMap.get(item);
	    }

	    @Override
	    public boolean hasStableIds() {
	      return true;
	    }
	
       }  */


