package com.example.bulletin_buzz;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
/* import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


	public class faculty extends ListActivity {
		  public void onCreate(Bundle icicle) {
		    super.onCreate(icicle);
		    String[] values = new String[] { "Dr. Manoj B Chandak ", "Rashmi Rajesh Welekar",
		    		"Tausif Diwan ",	"Rina S. Damdoo ","Aarti Manish Karandikar ",
		        "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
		        "Linux", "OS/2" };
		    // use your custom layout
		    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
		        R.layout.faculty_xml, R.id.firstline, values);
		    setListAdapter(adapter);
		  }

		  @Override
		  protected void onListItemClick(ListView l, View v, int position, long id) {
		    String item = (String) getListAdapter().getItem(position);
		    Toast.makeText(this, item + " selected", Toast.LENGTH_LONG).show();
		  }
		} 

*/
/*
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.SimpleAdapter;

public class faculty extends ListActivity {
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    ArrayList<Map<String, String>> list = buildData();
    String[] from = { "name", "availablilty","pic" };
   // int[] to = { android.R.id.text1, android.R.id.text2 };
    int[] to = { R.id.firstline, R.id.secondLine,R.id.icon};

    SimpleAdapter adapter = new SimpleAdapter(this, list,
       // android.
    		R.layout.faculty_xml, from, to);
    setListAdapter(adapter);
  }

  private ArrayList<Map<String, String>> buildData() {
    ArrayList<Map<String, String>> list = new ArrayList<Map<String, String>>();
    list.add(putData("Dr. Manoj B Chandak", "2-3pm",R.drawable.bg1));
    list.add(putData("Tausif Diwan ", "1-2pm",R.drawable.bg2));
    list.add(putData("Aarti Manish Karandikar ", "12-1pm",R.drawable.image_upload));
    list.add(putData("Rina S. Damdoo ", "12-1pm",R.drawable.profile));
    list.add(putData("Rashmi Rajesh Welekar", "1-2pm",R.drawable.profile));
    return list;
  }

  private HashMap<String, String,Integer> putData(String name, String purpose, int pic) {
    HashMap<String, String,Integer> item = new HashMap<String, String,Integer>();
    item.put("name", name);
    item.put("purpose", purpose);
    item.put("pic",pic );
    return item;
  }
  
} 
*/
	public class faculty extends Activity {
	  ListView list;
	  String[] web = { "Dr. Manoj B Chandak ", "Rashmi Rajesh Welekar",
	    		"Tausif Diwan ","Rina S. Damdoo ","Aarti Manish Karandikar "};
	  String[] time = { "1-2pm ","1-2pm","1-2pm","1-2pm","1-2pm"};
	    String[] place={"HOD Cabin-Cse Dept","Faculty Room beside room208-Cse Dept","Faculty Room-Cse Dept","Faculty Room beside 208-Cse Dept","Faculty Room-Cse Dept"};
	  Integer[] imageId = {
	      R.drawable.bg1,
	      R.drawable.bg2,
	      R.drawable.bg1,
	      R.drawable.bg2,
	      R.drawable.bg1,
	      
	  };
	  EditText inputSearch;
	  CustomList adapter;
	  @Override
	  protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.faculty2);
	     adapter = new
	        CustomList(faculty.this, web, imageId,time,place);
	    list=(ListView)findViewById(R.id.list);
	        list.setAdapter(adapter);
	        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
	                @Override
	                public void onItemClick(AdapterView<?> parent, View view,
	                                        int position, long id) {
	                    Toast.makeText(faculty.this, "You Clicked at " +web[+ position], Toast.LENGTH_SHORT).show();
	                }
	            });
	        
	        ////////////////////// SEARCH FUNCTION //////////
	        inputSearch = (EditText) findViewById(R.id.inputSearch);
	        inputSearch.addTextChangedListener(new TextWatcher() {
	            
	            @Override
	            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
	                // When user changed the Text
	                faculty.this.adapter.getFilter().filter(cs); 
                    Toast.makeText(faculty.this, "You Clicked at ", Toast.LENGTH_SHORT).show();
          //      String where = *YOURCOLUMN* + " LIKE '%" + cs + "%'";

          //      Cursor c = db.query(*TABLE*, *COLUMNS*, where, null, null, null, null);

            //        adapter.swapCursor(c);
                    adapter.notifyDataSetChanged();
	            }
	             
	            @Override
	            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
	                    int arg3) {
	                // TODO Auto-generated method stub
                    Toast.makeText(faculty.this, "before", Toast.LENGTH_SHORT).show();

	                 
	            }
	             
	            @Override
	            public void afterTextChanged(Editable arg0) {
	                // TODO Auto-generated method stub                          
	            }
	        });
	  
	  }
	}