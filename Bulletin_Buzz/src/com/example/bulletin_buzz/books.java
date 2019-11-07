package com.example.bulletin_buzz;


	import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.bulletin_buzz.mba.Insertpost;
import com.example.bulletin_buzz.mba.ListPost;

	import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

	public class books extends Activity {
		///////////  JSON VARIABLES ////////////////////////////
		private static  String GET_POST_URL ="http://10.0.2.2/bbuz/books.php"; 
		private static  String POST_URL ="http://10.0.2.2/bbuz/books_insert.php";    
		
		private static final String TAG_SUCCESS = "success";
		private static final String TAG_MESSAGE = "message";
		JSONParser jsonParser = new JSONParser();
		JSONObject json=new JSONObject();
		JSONObject json1=new JSONObject();
		JSONArray jsarr=new JSONArray();
		String got_name,got_id,got_bookdata;
		private ProgressDialog pDialog;
		String tag="log",uname,id1;
		////////////////////////////////////////////////////////
		ListView booklist;
		Button postbook3;
		EditText et3,dispose3;
		TextView heading;
		 public String[] newspost3 = new String[] { "dspd", 
		         "JAVA",
		         "Micro processor and interfacing",
		         "Computer Graphics", 
		         "Software Engg.", 
		         "List View Source Code", 
		         "List View Array Adapter", 
		         "Android Example List View"};
		 public String[] detailpost3 = new String[] { "Sunil B C", 
		         "Complete reference",
		         "ppt by sir",
		         "rogers", 
		         "Roger pressmen", 
		         "List View Source Code", 
		         "List View Array Adapter", 
		         "Android Example List View"};
		 private ArrayList<String> itemArrey3=new ArrayList<String>();
		   private ArrayAdapter<String> adapterb;
		protected void onCreate(Bundle savedInstanceState){
			super.onCreate(savedInstanceState);
			setContentView(R.layout.bookpage);
			Intent intent = getIntent();
 		     uname = intent.getStringExtra(testing.tNAME);
 		   new ListPost().execute();
			 et3 = (EditText) findViewById(R.id.editText1b);
			 postbook3=(Button)findViewById(R.id.bookpostbtn);
				booklist = (ListView) findViewById(R.id.listView1b);
			  heading=(TextView)findViewById(R.id.textView1b);
				heading.setText("List of available Books");
		  adapterb = new ArrayAdapter<String>(books.this,
		           android.R.layout.simple_list_item_1, android.R.id.text1, itemArrey3);
		     booklist.setAdapter(adapterb);
		    
		   booklist.setOnItemClickListener(new OnItemClickListener()
		     {	@Override
				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id) {
					 int itemPosition1     = position;
					  String  itemValue1    = (String) booklist.getItemAtPosition(position);
					  Toast.makeText(getApplicationContext(),
			                  "Position :"+itemPosition1+"  ListItem : " +itemValue1 , Toast.LENGTH_LONG)
			                  .show();
			              
			                	 
			              //  Intent intent = new Intent(books.this, writepost.class);
						//	startActivity(intent);
			}	});
		     
		    postbook3.setOnClickListener(new View.OnClickListener()
		    	{	@Override
				public void onClick(View v) {
					additemlist1();
					
				}  });
		}
		
		     protected void additemlist1() {
		   	  if (isInputValid(et3)) {                         ///et=====> EditText et  jaha haum post likh rai pge2.xml
		   		new Insertpost().execute();
		   		  itemArrey3.add(0,"Book Details:"+et3.getText().toString()+"\n"+"Available with:-"+"\n"+uname.toUpperCase());    /// (index,jaha se post lena hai) 
		 	        et3.setText("");                            ///ek bar post kr diya toh usko blank set kr dena

		 	        adapterb.notifyDataSetChanged();             

		 	    }   

		 	    }

		 	    protected boolean isInputValid(EditText etInput2) {
		 	        // TODO Auto-generatd method stub
		 	        if (etInput2.getText().toString().trim().length()<1) {
		 	            etInput2.setError("Please Enter Item");
		 	            return false;
		 	        } else {
		 	            return true;
		 	        }

		 	    }
		 	    
		 	    
		 //////////////////////////////    Async task  //////////////////////////////////// 

		 	   class ListPost extends AsyncTask<String, String, String> {

					/**
					 * Before starting background thread Show Progress Dialog
					 * */
					@Override
					protected void onPreExecute() {
						super.onPreExecute();
						Log.d("tag","In books asynctask on preexecute   ");
						pDialog = new ProgressDialog(books.this);
						pDialog.setMessage("Loading . Please wait...");
						pDialog.setIndeterminate(false);
						pDialog.setCancelable(false);
						pDialog.show();
					}
					/**
					 * getting All products from url
					 * */
					protected String doInBackground(String... args) {
						// Building Parameters
						Log.d(tag,"in doinbackground  ");
						List<NameValuePair> params = new ArrayList<NameValuePair>();
						// getting JSON string from URL
			            Log.d(tag,"before request ");
				 json = jsonParser.makeHttpRequest(GET_POST_URL, "GET", params);
						Log.d(tag,"after request ");
						// Check your log cat for JSON reponse
						Log.d("php return: ", json.toString());
							// Checking for SUCCESS TAG
						
					
	try {
					// Checking for SUCCESS TAG
		int success = json.getInt(TAG_SUCCESS);
						   
			if (success == 1) {
						// products found
						// Getting Array of Products
						jsarr = json.getJSONArray("products");
							
						Log.d(tag,"this is success log ");
							
						// looping through All Products
					for (int i = 0; i < jsarr.length(); i++)
					{
						JSONObject c = jsarr.getJSONObject(i);

							// Storing each json item in variable
				got_id = c.getString("id"); 
				got_name = c.getString("uname");
			 got_bookdata = c.getString("bookdata");
		 itemArrey3.add(0,"Book Details:"+got_bookdata+"\n"+"Available with:-"+"\n"+got_name);  
			System.out.println(itemArrey3.toString());						
					 }	}
			else {
								// no products found
								// Launch Add New product Activity
				}
		} catch (JSONException e) { e.printStackTrace();		}
						
	    return null;
		
	}


					/**
					 * After completing background task Dismiss the progress dialog
					 * **/
			protected void onPostExecute(String file_url) {
				// dismiss the dialog after getting all products
			              pDialog.dismiss();
						
			              Log.d(tag,"listview updated ");
		        }
			}

	////////////////////////// end async task ///////////
		 	   
		 	  class Insertpost extends AsyncTask<String, String, String> {
			  		 
			  		//boolean failure = false;
			  		 
			  		@Override
			  		protected void onPreExecute() {             /////////
			  		       super.onPreExecute();
			  		pDialog = new ProgressDialog(books.this);
			  		pDialog.setMessage("Attempting Insert...");
			  		pDialog.setIndeterminate(false);
			  		pDialog.setCancelable(true);
			  		pDialog.show();
			  		}
			  		 
			  		@Override
			  		protected String doInBackground(String... args) {
			  		// TODO Auto-generated method stub
			  		// Check for success tag
			  			pDialog.setMessage("background Insert...");
			  			Log.d("uname", "inserting for "+uname);
			  		  
			  		List<NameValuePair> params = new ArrayList<NameValuePair>();  pDialog.setMessage("after list array ...");
			 	params.add(new BasicNameValuePair("id", id1));//pass this value
			  		params.add(new BasicNameValuePair("uname", uname));//---
			  		params.add(new BasicNameValuePair("auth", "student"));//----
			  		params.add(new BasicNameValuePair("bookdata",et3.getText().toString()));
			  		 
			  		Log.d("request!", "starting");
			  		 
			  		 json1 = jsonParser.makeHttpRequest(POST_URL, "GET", params);
			  		 
			  		// check your log for json response
			  		Log.d("Insert book attempt", json1.toString());
			  		 
			  		// json success tag

			  		try {
			  			// Checking for SUCCESS TAG
			  			int success = json1.getInt(TAG_SUCCESS);
			  		   
			  			if (success == 1) {
			  				Log.d(tag,"SUCCESSFUL BOOK INSERTION ");

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
			  		
			  		
			  		}

			  		}
	
		}
		   


			





