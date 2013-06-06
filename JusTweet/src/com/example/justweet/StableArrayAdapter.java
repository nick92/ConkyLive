package com.example.justweet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class StableArrayAdapter extends ArrayAdapter<String>{
	
	private final Activity context;
	private ArrayList<String> names = new ArrayList<String>();
    
	static class ViewHolder {
		public TextView text;
		public TextView toptext;
	    public TextView bottomtext;
	    public ImageView image;
	}
	
	public StableArrayAdapter(Activity context, int textViewResourceId, List<String> objects) {
		super(context, textViewResourceId, objects);
		this.context = context;
		names.add(objects.get(0));
	}
	
    
    @SuppressLint("NewApi")
	@Override
    public View getView(int position, View convertView, ViewGroup parent) {
    	View rowView = convertView;
        if (rowView == null) {
          LayoutInflater inflater = context.getLayoutInflater();
          rowView = inflater.inflate(R.layout.row, null);
          ViewHolder viewHolder = new ViewHolder();
          viewHolder.text = (TextView) rowView.findViewById(R.id.text1);
          viewHolder.toptext = (TextView) rowView.findViewById(R.id.toptext);
          viewHolder.bottomtext = (TextView) rowView.findViewById(R.id.bottomtext);
          viewHolder.image = (ImageView) rowView.findViewById(R.id.icon);
          rowView.setTag(viewHolder);
        }

        ViewHolder holder = (ViewHolder) rowView.getTag();
        String s = names.get(0);
        holder.image.setImageResource(R.drawable.tolly_mister);
        holder.text.setText("String: "+s);
        holder.toptext.setText("Some text");
        holder.bottomtext.setText("Created at 10:10:10");
        return rowView;
    }    
}