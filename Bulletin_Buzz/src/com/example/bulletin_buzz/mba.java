package com.example.bulletin_buzz;

import java.util.ArrayList;

import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class mba extends Activity {
	
	
	private ProgressDialog pDialog;
	String tag="log" ;

	// JSON parser class
	JSONParser jsonParser = new JSONParser();
	private static  String POST_URL ="http://10.0.2.2/bbuz/post.php";    
	private static  String GET_POST_URL ="http://10.0.2.2/bbuz/get_post.php";  
	////"http://10.0.2.2/bbuz/login.php";
	private static final String TAG_SUCCESS = "success";
	private static final String TAG_MESSAGE = "message";

	JSONObject json=new JSONObject();
	JSONObject json1=new JSONObject();
	JSONArray jsarr=new JSONArray();
	String got_name,got_id,got_postdata;
	Button bcomment; EditText writecmt;
	ListView clist;
	String count="5",uname,pwd,id1;
	int cnt=1,id;
	  private ArrayList<String> itemArrey2 = new ArrayList<String>();
	    private ArrayAdapter<String> adapter2;
	    public String[] cmtlist = new String[] { "Which is the best Institute for prep of MBA in Nagpur", 
	               "Latest technology to work on :hadoop"};
	    
	  public void onCreate(Bundle icicle) {
		    super.onCreate(icicle);
		    setContentView(R.layout.mba);

			Intent intent = getIntent();
	  		     uname = intent.getStringExtra(career.cNAME);
	  		    //  id1 = intent.getStringExtra(MainActivity.ID);
	  		 /*       Bundle extras = getIntent().getExtras();
	  		 if(extras !=null) {
	  		     uname = extras.getString("NAME");
	  		  // id1 = extras.getString("ID");
	  		   //id=Integer.parseInt(id1);
	  		 } */
	  		 
	  	/*	Intent i = getIntent();
	  	    if (i.hasExtra("NAME")){
	  	        uname = i.getStringExtra("NAME"); }  */
	  		Log.d("uname", uname);
		   
		    new ListPost().execute();
		   
		    //Log.d("itemArrey2", itemArrey2[i]);
		    bcomment = (Button) findViewById(R.id.bcomment);
		    writecmt=(EditText)findViewById(R.id.writecmt);
			clist = (ListView) findViewById(R.id.cmtlistView);
			
			//itemArrey2 = new ArrayList<String>();
	/*		for(int j=0;j<cmtlist.length;j++)
			  itemArrey2.add(cmtlist[j]); */
			 adapter2 = new ArrayAdapter<String>(mba.this,
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
	  	    	new Insertpost().execute();
	  	    itemArrey2.add(0,"Name : "+uname+" \n"+"Post:"+writecmt.getText().toString());    
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
	  	    
	  	    /////////////////// new class ///////////////
	  	  class Insertpost extends AsyncTask<String, String, String> {
	  		 
	  		//boolean failure = false;
	  		 
	  		@Override
	  		protected void onPreExecute() {             /////////
	  		       super.onPreExecute();
	  		pDialog = new ProgressDialog(mba.this);
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
	  		params.add(new BasicNameValuePair("postdata",writecmt.getText().toString()));
	  		 
	  		Log.d("request!", "starting");
	  		 
	  		 json1 = jsonParser.makeHttpRequest(POST_URL, "GET", params);
	  		 
	  		// check your log for json response
	  		Log.d("Insert attempt", json1.toString());
	  		 
	  		// json success tag

	  		try {
	  			// Checking for SUCCESS TAG
	  			int success = json1.getInt(TAG_SUCCESS);
	  		   
	  			if (success == 1) {
	  				Log.d(tag,"this is success log ");

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
	  	    

	  	class ListPost extends AsyncTask<String, String, String> {

			/**
			 * Before starting background thread Show Progress Dialog
			 * */
			@Override
			protected void onPreExecute() {
				super.onPreExecute();
				Log.d("tag","In asynctasl on preexecute   ");
				pDialog = new ProgressDialog(mba.this);
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
				
			/*	try {
					jsarr=json.getJSONArray("products");
					for(int i=0;i<jsarr.length();i++)
					{
						JSONObject j=jsarr.getJSONObject(i);
						Log.d(tag, j.toString());
						
						String uname=j.getString("uname");
						String post=j.getString("postdata");
						//addItemList 
						/*HashMap<String, String> tmphostel = new HashMap<String, String>();
						tmphostel.put(TAG_REGNO, regno);
						tmphostel.put(TAG_NAME, name);
						HostelList.add(tmphostel);*/
				/*		itemArrey2.add(0,uname+" :--   "+post);  
						 
					}
					Log.d(tag+"array",jsarr.toString());
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					Log.d(tag,"exception ");
				} */
				try {
					// Checking for SUCCESS TAG
					int success = json.getInt(TAG_SUCCESS);
				   
					if (success == 1) {
						// products found
						// Getting Array of Products
						jsarr = json.getJSONArray("products");
					
						Log.d(tag,"this is success log ");
						
						// looping through All Products
					for (int i = 0; i < jsarr.length(); i++) {
						JSONObject c = jsarr.getJSONObject(i);

						// Storing each json item in variable
					got_id = c.getString("id"); 
					got_name = c.getString("uname");
					got_postdata = c.getString("postdata");
			 itemArrey2.add(0,"Name:- "+got_name+"\n"+"Post :--   "+got_postdata);  
							
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


			/**
			 * After completing background task Dismiss the progress dialog
			 * **/
			protected void onPostExecute(String file_url) {
				// dismiss the dialog after getting all products
	                pDialog.dismiss();
				//pDialog.dismiss();
				/*ListAdapter adapter = new SimpleAdapter(
	                    ListHostelActivity.this, HostelList,
	                    R.layout.list_item, new String[] { TAG_NAME, TAG_REGNO,
	                           }, new int[] { R.id.name,R.id.regno});
	 
	            setListAdapter(adapter);*/
	                Log.d(tag,"listview updated ");
	        }
			}

	  	    
	  }

