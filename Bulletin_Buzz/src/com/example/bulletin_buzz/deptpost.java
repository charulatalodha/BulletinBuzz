package com.example.bulletin_buzz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.SimpleAdapter;

public class deptpost extends ListActivity {

	protected void onCreate(Bundle savedInstanceState) 
	  {
	    super.onCreate(savedInstanceState);
	    ArrayList<Map<String, String>> list = buildData();
	    String[] from = { "heading", "news", };
	    int[] to = { R.id.heading, R.id.writenews};

	    SimpleAdapter adapter = new SimpleAdapter(deptpost.this, list,
	    		R.layout.dept_row, from, to);
	    setListAdapter(adapter);
	  }

	  private ArrayList<Map<String, String>> buildData() {
	    ArrayList<Map<String, String>> list = new ArrayList<Map<String, String>>();
	    list.add(putData("Open Elective form filling", "Open Elective form filling is" +
	    		"scheduled at 2-3pm"));
	    list.add(putData("State Govt Schlorship ", "Did you know about our premium hosting service?" +
	    		"- It includes a premium domain name such as yourdomain.com absolutely free and for life" +
	    		"- You and your friends will be able to have email addresses such as you@yourdomain.com" +
	    		"- Premium servers are much stable and service comes will all guarantees like uptime and backups-" +
	    		" You will have unlimited disk space for your uploads and website!- 2 cool website builders will be included- " +
	    		"Over 250 scripts such as forums, blogs, e-shops will be ready to auto install in 1 click"+
                 "                                                       "+
	    		"All is just for $4.84 per month (all credit cards and PayPal accepted). Reseller plans are also available."+
           "To register go to http://www.000webhost.com/upgrade or open our premium hosting website Hosting24.com directly "));
	    list.add(putData("MI Assignment 2 ", "12-1pm"));
	    list.add(putData("sem V -TimeTable", "12-1pm"));
	    list.add(putData("Project Seminars", "1-2pm"));
	    return list;
	  }

	  private HashMap<String, String> putData(String name, String purpose) 
	  {
	    HashMap<String, String> item = new HashMap<String, String>();
	    item.put("heading", name);
	    item.put("news", purpose);
	    return item;
	}
}


/*
import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

 public class deptpost extends Activity {
	     
	    // List view
	    private ListView lv;
	     
	    // Listview Adapter
	    ArrayAdapter<String> adapter;
	     
	    
	     
	     
	    // ArrayList for Listview
	    ArrayList<HashMap<String, String>> newslist;
	 
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.cse_notices);
	         
	        // Listview Data
	        String products[] = {"Dell Inspiron", "HTC One X", "HTC Wildfire S", "HTC Sense", "HTC Sensation XE",
	                                "iPhone 4S", "Samsung Galaxy Note 800",
	                                "Samsung Galaxy S3", "MacBook Air", "Mac Mini", "MacBook Pro"};
	         
	        lv = (ListView) findViewById(R.id.csenoticeslist);
	         
	        // Adding items to listview
	        adapter = new ArrayAdapter<String>(this, R.layout.dept_row, R.id.writenews, products);
	        lv.setAdapter(adapter);       
	         
	    }	
} */

/* 
 * 
 * import java.util.ArrayList;
import java.util.HashMap;

import android.app.ListActivity;
import android.widget.SimpleAdapter;

public class deptpost extends ListActivity 
{
	 ArrayList<HashMap<String,String>> list = 
			new ArrayList<HashMap<String,String>>();
	 void onCreate(){
		 setContentView(R.layout.cse_notices);
		 SimpleAdapter adapter = new SimpleAdapter(
		 this,
		 list,
		 R.layout.dept_row,
		 new String[] {"heading","news"},
		 new int[] {R.id.heading,R.id.writenews}

		 );
		 populateList();


		 setListAdapter(adapter);
	 }
	private void populateList() {
		HashMap<String,String> temp = new HashMap<String,String>();
		temp.put("heading","MONT Blanc");
		temp.put("news", "200.00$");
		list.add(temp);
		HashMap<String,String> temp1 = new HashMap<String,String>();
		temp1.put("heading","Gucci");
		temp1.put("news", "300.00$");
		
		list.add(temp1);
		HashMap<String,String> temp2 = new HashMap<String,String>();
		temp2.put("heading","Parker");
		temp2.put("news", "400.00$");
		list.add(temp2);
	}
}
*/
