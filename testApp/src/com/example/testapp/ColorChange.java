package com.example.testapp;

import java.util.Date;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ColorChange extends LinearLayout{
	
	private View mValue;
	private ImageView mImage;
	private Date d;  
	
	public ColorChange(Context context, AttributeSet attrs) {
		super(context, attrs);
		
		TypedArray a = context.obtainStyledAttributes(attrs,R.styleable.Options, 0, 0);
		String titleText = a.getString(R.styleable.Options_titleText);
		int valueColor = a.getColor(R.styleable.Options_valueColor,android.R.color.holo_blue_light);
	    d = new Date();
	    setGravity(Gravity.CENTER_VERTICAL);

	    LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	    inflater.inflate(R.layout.color_options, this, true);

	    TextView title = (TextView) getChildAt(0);
	    title.setText(d.toString());
	    
	    mValue = getChildAt(1);
	    mValue.setBackgroundColor(valueColor);

	    mImage = (ImageView) getChildAt(2);
	    
	    a.recycle();
	}

	
}
