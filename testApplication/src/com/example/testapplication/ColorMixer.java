package com.example.testapplication;
	

	import android.content.Context;
	import android.content.res.TypedArray;
	import android.graphics.BitmapFactory;
	import android.graphics.Canvas;
	import android.graphics.Paint;
	import android.util.AttributeSet;
	import android.view.Gravity;
	import android.view.LayoutInflater;
	import android.view.SurfaceHolder;
	import android.view.View;
	import android.widget.ImageView;
	import android.widget.LinearLayout;
	import android.widget.TextView;

	public class ColorMixer extends LinearLayout  {
	  
	  private View mValue;
	  private ImageView mImage;
	  private String titleText;
	  private int valueColor;
	  Paint paint;
	  
	  public ColorMixer(Context context, AttributeSet attrs) {
	    super(context, attrs);

	    TypedArray a = context.obtainStyledAttributes(attrs,R.styleable.ColorMixer, 0, 0);
        titleText = a.getString(R.styleable.ColorMixer_titleText);
        valueColor = a.getColor(R.styleable.ColorMixer_initialColor,android.R.color.holo_blue_light);
        a.recycle();
        
        setOrientation(LinearLayout.HORIZONTAL);
        setGravity(Gravity.CENTER_VERTICAL);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.activity_main, this, true);

        TextView title = (TextView) getChildAt(0);
        title.setText(titleText);
	  }
}
