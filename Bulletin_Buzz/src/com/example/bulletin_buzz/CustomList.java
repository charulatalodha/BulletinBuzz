package com.example.bulletin_buzz;


	import android.app.Activity;
	import android.view.LayoutInflater;
	import android.view.View;
	import android.view.ViewGroup;
	import android.widget.ArrayAdapter;
	import android.widget.ImageView;
	import android.widget.TextView;
	public class CustomList extends ArrayAdapter<String>{
	private final Activity context;
	private final String[] web,time,place;
	private final Integer[] imageId;
	
public CustomList(Activity context,
	String[] web, Integer[] imageId,String[] time,String[] place) {
	super(context, R.layout.list_single,web);
	this.context = context;
	this.web = web;
	this.place=place; this.time=time;
	this.imageId = imageId;
	}
	@Override
	public View getView(int position, View view, ViewGroup parent) {
	LayoutInflater inflater = context.getLayoutInflater();
	View rowView= inflater.inflate(R.layout.list_single, null, true);
	TextView txtTitle = (TextView) rowView.findViewById(R.id.txt);
	TextView txt2 = (TextView) rowView.findViewById(R.id.txt2);
	TextView txt3 = (TextView) rowView.findViewById(R.id.txt3);

	ImageView imageView = (ImageView) rowView.findViewById(R.id.img);
	txtTitle.setText(web[position]);
	txt2.setText(time[position]);txt3.setText(place[position]);
	imageView.setImageResource(imageId[position]);
	return rowView;
	}
	}
