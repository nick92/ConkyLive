package com.example.testapp;

import java.util.Date;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	Handler handler = new Handler();
	Date d;
	private View mValue;
	private ImageView mImage;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void onClicked(View view) {
	    String text = view.getId() == R.id.view1 ? "Background" : "Foreground";
	    Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
	  }
	
	@Override
	protected void onResume() {
		super.onResume();
	}
	
	
	@Override
	protected void onPause() {
		super.onPause();
	}
	
}
