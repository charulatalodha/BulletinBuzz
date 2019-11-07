package com.example.bulletin_buzz;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
	public class dept extends ListActivity {
		  public void onCreate(Bundle icicle) {
		    super.onCreate(icicle);
		    String[] values = new String[] { "Civil ","CSE",
		    		"IT","EC","EN","EDT","Electrical","Industrial","First Year"};
		    
		    // use your custom layout
		    ArrayAdapter<String> adapter = new ArrayAdapter<String>(dept.this,
		    		android.R.layout.simple_list_item_1,android.R.id.text1 , values);
		    setListAdapter(adapter);
		  }

		  @Override
		  protected void onListItemClick(ListView l, View v, int position, long id) {
		    String item = (String) getListAdapter().getItem(position);
		    Toast.makeText(this, item + " selected", Toast.LENGTH_LONG).show();
		    Intent intent = new Intent(dept.this, deptpost.class);
		    startActivity(intent);
		  }

	}
