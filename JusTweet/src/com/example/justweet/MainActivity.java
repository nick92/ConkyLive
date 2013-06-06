package com.example.justweet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	private int counter = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ListView listv = (ListView) findViewById(R.id.listview);
		
		final String[] strArr = new String[] {"Nick_Wilkins", "Isn't this weather nice", "Created at 10:02:20", "Good Day", "Bonjour" };
		
		final ArrayList<String> list = new ArrayList<String>();
		
		list.add(strArr[0]);
		
		final StableArrayAdapter adapter = new StableArrayAdapter(this, R.layout.row, list);
		
		//final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);		
		listv.setAdapter(adapter);
		
		final Context context = this;
		
		Button btn1 = (Button) findViewById(R.id.button1);
 		btn1.setOnClickListener(new View.OnClickListener() {
			@Override
 			public void onClick(View arg0) {
 					counter ++;
 					list.add(0, strArr[counter]);
 					adapter.add(strArr[counter]);
 					adapter.notifyDataSetChanged();
 			}
 		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
}