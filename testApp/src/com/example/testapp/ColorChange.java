package com.example.testapp;

import java.util.Date;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ColorChange extends View {
	
	private View mValue;
	private ImageView mImage;
	private Date d;  
	private ShapeDrawable mDrawable;
	private Canvas c;
	private Paint paint = new Paint();
	private String titleText;
	
	public ColorChange(Context context, AttributeSet attrs) {
		super(context, attrs);
		
		int x = 10;
	    int y = 10;
	    int width = 300;
	    int height = 50;

	    mDrawable = new ShapeDrawable(new OvalShape());
        mDrawable.getPaint().setColor(0xff74AC23);
        mDrawable.setBounds(x, y, x + width, y + height);
  
		TypedArray a = context.obtainStyledAttributes(attrs,R.styleable.Options, 0, 0);
		titleText = a.getString(R.styleable.Options_titleText);
		int valueColor = a.getColor(R.styleable.Options_valueColor,android.R.color.holo_blue_light);
	    d = new Date();
	    LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	    a.recycle();
	}
	protected void onDraw(Canvas c) {
		c.save();
		c.drawText(titleText, 20, 200, paint);
		mDrawable.draw(c);
		
		c.restore();
    }
	
}
